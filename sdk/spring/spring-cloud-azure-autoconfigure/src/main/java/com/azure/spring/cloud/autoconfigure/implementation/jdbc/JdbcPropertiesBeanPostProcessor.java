// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.cloud.autoconfigure.implementation.jdbc;

import com.azure.spring.cloud.autoconfigure.implementation.context.properties.AzureGlobalProperties;
import com.azure.spring.cloud.autoconfigure.implementation.passwordless.properties.AzureJdbcPasswordlessProperties;
import com.azure.spring.cloud.core.implementation.util.AzurePasswordlessPropertiesUtils;
import com.azure.spring.cloud.core.implementation.util.AzureSpringIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.MYSQL_PROPERTY_CONNECTION_ATTRIBUTES_ATTRIBUTE_EXTENSION_VERSION;
import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.MYSQL_PROPERTY_CONNECTION_ATTRIBUTES_DELIMITER;
import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.MYSQL_PROPERTY_CONNECTION_ATTRIBUTES_KV_DELIMITER;
import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.MYSQL_PROPERTY_NAME_CONNECTION_ATTRIBUTES;
import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.POSTGRESQL_PROPERTY_NAME_APPLICATION_NAME;
import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.POSTGRESQL_PROPERTY_NAME_ASSUME_MIN_SERVER_VERSION;
import static com.azure.spring.cloud.autoconfigure.implementation.jdbc.JdbcPropertyConstants.POSTGRESQL_PROPERTY_VALUE_ASSUME_MIN_SERVER_VERSION;
import static com.azure.spring.cloud.autoconfigure.implementation.util.SpringPasswordlessPropertiesUtils.enhancePasswordlessProperties;


/**
 * {@link BeanPostProcessor} to enhance jdbc connection string.
 */
class JdbcPropertiesBeanPostProcessor implements BeanPostProcessor, EnvironmentAware, ApplicationContextAware, PriorityOrdered {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcPropertiesBeanPostProcessor.class);
    private GenericApplicationContext applicationContext;
    private Environment environment;

    @Override
    public int getOrder() {
        // Runs before JdbcConnectionDetailsBeanPostProcessor
        return Ordered.HIGHEST_PRECEDENCE + 3;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSourceProperties) {
            DataSourceProperties dataSourceProperties = (DataSourceProperties) bean;
            BeanDefinition bd = applicationContext.getBeanDefinition(beanName);
            String datasourcePropertiesPrefix = "spring.datasource";
            if (bd != null && bd.getSource() instanceof AnnotatedTypeMetadata metadata) {
                Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConfigurationProperties.class.getName());
                if (annotationAttributes != null) {
                    datasourcePropertiesPrefix = (String) annotationAttributes.get("prefix");
                }
            }
            String passwordlessPropertiesPrefix = datasourcePropertiesPrefix + ".azure";
            AzureJdbcPasswordlessProperties properties = buildAzureProperties(passwordlessPropertiesPrefix);
            if (!properties.isPasswordlessEnabled()) {
                LOGGER.debug("Feature passwordless authentication is not enabled(bean name is {} and {}.passwordless-enabled=false), "
                    + "skip enhancing jdbc url.", beanName, passwordlessPropertiesPrefix);
                return bean;
            }

            String url = dataSourceProperties.getUrl();
            if (!StringUtils.hasText(url)) {
                LOGGER.debug("No '{}.url' provided, skip enhancing jdbc url.", datasourcePropertiesPrefix);
                return bean;
            }

            JdbcConnectionString connectionString = JdbcConnectionString.resolve(url);
            if (connectionString == null) {
                LOGGER.debug("Can not resolve jdbc connection string from provided {}, skip enhancing jdbc url.", url);
                return bean;
            }

            boolean isPasswordProvided = StringUtils.hasText(dataSourceProperties.getPassword());
            if (isPasswordProvided) {
                LOGGER.debug(
                    "If you are using Azure hosted services,"
                    + "it is encouraged to use the passwordless feature ({}). "
                    + "Please refer to https://aka.ms/passwordless-connections.", datasourcePropertiesPrefix);
                return bean;
            }

            DatabaseType databaseType = connectionString.getDatabaseType();
            if (!databaseType.isDatabasePluginAvailable()) {
                LOGGER.debug("The jdbc plugin with provided jdbc schema is not on the classpath, "
                    + "skip enhancing jdbc url ({}).", datasourcePropertiesPrefix);
                return bean;
            }

            try {
                JdbcConnectionStringEnhancer enhancer = new JdbcConnectionStringEnhancer(connectionString);
                enhancer.enhanceProperties(buildEnhancedProperties(passwordlessPropertiesPrefix, databaseType, properties), true);
                enhanceUserAgent(databaseType, enhancer);
                ((DataSourceProperties) bean).setUrl(enhancer.getJdbcUrl());
            } catch (IllegalArgumentException e) {
                LOGGER.error("Inconsistent properties detected, skip enhancing jdbc url ({}).", datasourcePropertiesPrefix, e);
            }
        }
        return bean;
    }

    private void enhanceUserAgent(DatabaseType databaseType, JdbcConnectionStringEnhancer enhancer) {
        if (DatabaseType.MYSQL == databaseType) {
            Map<String, String> enhancedAttributes = new HashMap<>();
            enhancedAttributes.put(MYSQL_PROPERTY_CONNECTION_ATTRIBUTES_ATTRIBUTE_EXTENSION_VERSION,
                AzureSpringIdentifier.AZURE_SPRING_MYSQL_OAUTH);
            enhancer.enhancePropertyAttributes(
                MYSQL_PROPERTY_NAME_CONNECTION_ATTRIBUTES,
                enhancedAttributes,
                MYSQL_PROPERTY_CONNECTION_ATTRIBUTES_DELIMITER,
                MYSQL_PROPERTY_CONNECTION_ATTRIBUTES_KV_DELIMITER
            );
        } else if (DatabaseType.POSTGRESQL == databaseType) {
            Map<String, String> enhancedProperties = new HashMap<>();
            enhancedProperties.put(POSTGRESQL_PROPERTY_NAME_APPLICATION_NAME,
                AzureSpringIdentifier.AZURE_SPRING_POSTGRESQL_OAUTH);
            // Set property assumeMinServerVersion with value "9.0.0" here for the following reasons:
            // 1. We need to set application_name in paramList to build connections with postgresql server, in order to do that, the number of assumeVersion must >= 9.0.0.
            //    https://github.com/pgjdbc/pgjdbc/blob/98c04a0c903e90f2d5d10a09baf1f753747b2556/pgjdbc/src/main/java/org/postgresql/core/v3/ConnectionFactoryImpl.java#L360
            // 2. The minimum supported version of Azure postgresql, both single server and flexible server, is greater than 9.0.0.
            //    https://learn.microsoft.com/azure/postgresql/single-server/concepts-supported-versions
            //    https://learn.microsoft.com/azure/postgresql/flexible-server/concepts-supported-versions
            enhancedProperties.put(POSTGRESQL_PROPERTY_NAME_ASSUME_MIN_SERVER_VERSION,
                POSTGRESQL_PROPERTY_VALUE_ASSUME_MIN_SERVER_VERSION);
            enhancer.enhanceProperties(enhancedProperties, true);
        }
    }

    private Map<String, String> buildEnhancedProperties(String passwordlessPropertiesPrefix,
                                                        DatabaseType databaseType,
                                                        AzureJdbcPasswordlessProperties properties) {
        Map<String, String> result = new HashMap<>();
        enhancePasswordlessProperties(passwordlessPropertiesPrefix, properties, result);
        databaseType.setDefaultEnhancedProperties(result);
        return result;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (GenericApplicationContext) applicationContext;
    }

    private AzureJdbcPasswordlessProperties buildAzureProperties(String azureDatasourcePrefix) {
        AzureGlobalProperties azureGlobalProperties = applicationContext.getBean(AzureGlobalProperties.class);
        AzureJdbcPasswordlessProperties azurePasswordlessProperties = Binder.get(environment)
                .bindOrCreate(azureDatasourcePrefix, AzureJdbcPasswordlessProperties.class);

        AzureJdbcPasswordlessProperties mergedProperties = new AzureJdbcPasswordlessProperties();
        AzurePasswordlessPropertiesUtils.mergeAzureCommonProperties(azureGlobalProperties, azurePasswordlessProperties, mergedProperties);
        return mergedProperties;
    }
}
