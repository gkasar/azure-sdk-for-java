// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.cosmos.fluent.models.RestorableGremlinGraphGetResultInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The List operation response, that contains the Gremlin graph events and their properties. */
@Immutable
public final class RestorableGremlinGraphsListResult {
    /*
     * List of Gremlin graph events and their properties.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<RestorableGremlinGraphGetResultInner> value;

    /** Creates an instance of RestorableGremlinGraphsListResult class. */
    public RestorableGremlinGraphsListResult() {
    }

    /**
     * Get the value property: List of Gremlin graph events and their properties.
     *
     * @return the value value.
     */
    public List<RestorableGremlinGraphGetResultInner> value() {
        return this.value;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}