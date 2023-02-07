// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.reservations.models.ExchangeOperationResultStatus;
import com.azure.resourcemanager.reservations.models.ExchangeResponseProperties;
import com.azure.resourcemanager.reservations.models.OperationResultError;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Exchange operation result. */
@Fluent
public final class ExchangeOperationResultResponseInner {
    /*
     * It should match what is used to GET the operation result.
     */
    @JsonProperty(value = "id")
    private String id;

    /*
     * It must match the last segment of the id field, and will typically be a GUID / system generated value.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Status of the operation.
     */
    @JsonProperty(value = "status")
    private ExchangeOperationResultStatus status;

    /*
     * Exchange response properties
     */
    @JsonProperty(value = "properties")
    private ExchangeResponseProperties properties;

    /*
     * Required if status == failed or status == canceled.
     */
    @JsonProperty(value = "error")
    private OperationResultError error;

    /** Creates an instance of ExchangeOperationResultResponseInner class. */
    public ExchangeOperationResultResponseInner() {
    }

    /**
     * Get the id property: It should match what is used to GET the operation result.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: It should match what is used to GET the operation result.
     *
     * @param id the id value to set.
     * @return the ExchangeOperationResultResponseInner object itself.
     */
    public ExchangeOperationResultResponseInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name property: It must match the last segment of the id field, and will typically be a GUID / system
     * generated value.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: It must match the last segment of the id field, and will typically be a GUID / system
     * generated value.
     *
     * @param name the name value to set.
     * @return the ExchangeOperationResultResponseInner object itself.
     */
    public ExchangeOperationResultResponseInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the status property: Status of the operation.
     *
     * @return the status value.
     */
    public ExchangeOperationResultStatus status() {
        return this.status;
    }

    /**
     * Set the status property: Status of the operation.
     *
     * @param status the status value to set.
     * @return the ExchangeOperationResultResponseInner object itself.
     */
    public ExchangeOperationResultResponseInner withStatus(ExchangeOperationResultStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get the properties property: Exchange response properties.
     *
     * @return the properties value.
     */
    public ExchangeResponseProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Exchange response properties.
     *
     * @param properties the properties value to set.
     * @return the ExchangeOperationResultResponseInner object itself.
     */
    public ExchangeOperationResultResponseInner withProperties(ExchangeResponseProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the error property: Required if status == failed or status == canceled.
     *
     * @return the error value.
     */
    public OperationResultError error() {
        return this.error;
    }

    /**
     * Set the error property: Required if status == failed or status == canceled.
     *
     * @param error the error value to set.
     * @return the ExchangeOperationResultResponseInner object itself.
     */
    public ExchangeOperationResultResponseInner withError(OperationResultError error) {
        this.error = error;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
        if (error() != null) {
            error().validate();
        }
    }
}