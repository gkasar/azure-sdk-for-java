// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Properties for reservation split. */
@Fluent
public final class SplitProperties {
    /*
     * List of the quantities in the new reservations to create.
     */
    @JsonProperty(value = "quantities")
    private List<Integer> quantities;

    /*
     * Resource id of the reservation to be split. Format of the resource id should be
     * /providers/Microsoft.Capacity/reservationOrders/{reservationOrderId}/reservations/{reservationId}
     */
    @JsonProperty(value = "reservationId")
    private String reservationId;

    /** Creates an instance of SplitProperties class. */
    public SplitProperties() {
    }

    /**
     * Get the quantities property: List of the quantities in the new reservations to create.
     *
     * @return the quantities value.
     */
    public List<Integer> quantities() {
        return this.quantities;
    }

    /**
     * Set the quantities property: List of the quantities in the new reservations to create.
     *
     * @param quantities the quantities value to set.
     * @return the SplitProperties object itself.
     */
    public SplitProperties withQuantities(List<Integer> quantities) {
        this.quantities = quantities;
        return this;
    }

    /**
     * Get the reservationId property: Resource id of the reservation to be split. Format of the resource id should be
     * /providers/Microsoft.Capacity/reservationOrders/{reservationOrderId}/reservations/{reservationId}.
     *
     * @return the reservationId value.
     */
    public String reservationId() {
        return this.reservationId;
    }

    /**
     * Set the reservationId property: Resource id of the reservation to be split. Format of the resource id should be
     * /providers/Microsoft.Capacity/reservationOrders/{reservationOrderId}/reservations/{reservationId}.
     *
     * @param reservationId the reservationId value to set.
     * @return the SplitProperties object itself.
     */
    public SplitProperties withReservationId(String reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}