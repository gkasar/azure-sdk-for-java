// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managedapplications.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.managedapplications.fluent.JitRequestsClient;
import com.azure.resourcemanager.managedapplications.fluent.models.JitRequestDefinitionInner;
import com.azure.resourcemanager.managedapplications.fluent.models.JitRequestDefinitionListResultInner;
import com.azure.resourcemanager.managedapplications.models.JitRequestDefinition;
import com.azure.resourcemanager.managedapplications.models.JitRequestDefinitionListResult;
import com.azure.resourcemanager.managedapplications.models.JitRequests;

public final class JitRequestsImpl implements JitRequests {
    private static final ClientLogger LOGGER = new ClientLogger(JitRequestsImpl.class);

    private final JitRequestsClient innerClient;

    private final com.azure.resourcemanager.managedapplications.ApplicationManager serviceManager;

    public JitRequestsImpl(JitRequestsClient innerClient,
        com.azure.resourcemanager.managedapplications.ApplicationManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<JitRequestDefinition> getByResourceGroupWithResponse(String resourceGroupName,
        String jitRequestName, Context context) {
        Response<JitRequestDefinitionInner> inner
            = this.serviceClient().getByResourceGroupWithResponse(resourceGroupName, jitRequestName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new JitRequestDefinitionImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public JitRequestDefinition getByResourceGroup(String resourceGroupName, String jitRequestName) {
        JitRequestDefinitionInner inner = this.serviceClient().getByResourceGroup(resourceGroupName, jitRequestName);
        if (inner != null) {
            return new JitRequestDefinitionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteByResourceGroupWithResponse(String resourceGroupName, String jitRequestName,
        Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, jitRequestName, context);
    }

    public void deleteByResourceGroup(String resourceGroupName, String jitRequestName) {
        this.serviceClient().delete(resourceGroupName, jitRequestName);
    }

    public Response<JitRequestDefinitionListResult> listBySubscriptionWithResponse(Context context) {
        Response<JitRequestDefinitionListResultInner> inner
            = this.serviceClient().listBySubscriptionWithResponse(context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new JitRequestDefinitionListResultImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public JitRequestDefinitionListResult listBySubscription() {
        JitRequestDefinitionListResultInner inner = this.serviceClient().listBySubscription();
        if (inner != null) {
            return new JitRequestDefinitionListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<JitRequestDefinitionListResult> listByResourceGroupWithResponse(String resourceGroupName,
        Context context) {
        Response<JitRequestDefinitionListResultInner> inner
            = this.serviceClient().listByResourceGroupWithResponse(resourceGroupName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new JitRequestDefinitionListResultImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public JitRequestDefinitionListResult listByResourceGroup(String resourceGroupName) {
        JitRequestDefinitionListResultInner inner = this.serviceClient().listByResourceGroup(resourceGroupName);
        if (inner != null) {
            return new JitRequestDefinitionListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public JitRequestDefinition getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String jitRequestName = ResourceManagerUtils.getValueFromIdByName(id, "jitRequests");
        if (jitRequestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'jitRequests'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, jitRequestName, Context.NONE).getValue();
    }

    public Response<JitRequestDefinition> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String jitRequestName = ResourceManagerUtils.getValueFromIdByName(id, "jitRequests");
        if (jitRequestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'jitRequests'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, jitRequestName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String jitRequestName = ResourceManagerUtils.getValueFromIdByName(id, "jitRequests");
        if (jitRequestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'jitRequests'.", id)));
        }
        this.deleteByResourceGroupWithResponse(resourceGroupName, jitRequestName, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String jitRequestName = ResourceManagerUtils.getValueFromIdByName(id, "jitRequests");
        if (jitRequestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'jitRequests'.", id)));
        }
        return this.deleteByResourceGroupWithResponse(resourceGroupName, jitRequestName, context);
    }

    private JitRequestsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.managedapplications.ApplicationManager manager() {
        return this.serviceManager;
    }

    public JitRequestDefinitionImpl define(String name) {
        return new JitRequestDefinitionImpl(name, this.manager());
    }
}
