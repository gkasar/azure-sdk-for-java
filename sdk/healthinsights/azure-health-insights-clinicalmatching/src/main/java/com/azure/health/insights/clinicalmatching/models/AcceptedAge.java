// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.health.insights.clinicalmatching.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A person's age, given as a number (value) and a unit (e.g. years, months). */
@Immutable
public final class AcceptedAge {
    /*
     * Possible units for a person's age.
     */
    @JsonProperty(value = "unit", required = true)
    private AgeUnit unit;

    /*
     * The number of years/months/days that represents the person's age.
     */
    @JsonProperty(value = "value", required = true)
    private double value;

    /**
     * Creates an instance of AcceptedAge class.
     *
     * @param unit the unit value to set.
     * @param value the value value to set.
     */
    @JsonCreator
    public AcceptedAge(
            @JsonProperty(value = "unit", required = true) AgeUnit unit,
            @JsonProperty(value = "value", required = true) double value) {
        this.unit = unit;
        this.value = value;
    }

    /**
     * Get the unit property: Possible units for a person's age.
     *
     * @return the unit value.
     */
    public AgeUnit getUnit() {
        return this.unit;
    }

    /**
     * Get the value property: The number of years/months/days that represents the person's age.
     *
     * @return the value value.
     */
    public double getValue() {
        return this.value;
    }
}