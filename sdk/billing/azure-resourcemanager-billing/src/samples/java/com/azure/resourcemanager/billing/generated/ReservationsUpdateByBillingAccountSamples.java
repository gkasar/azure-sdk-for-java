// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.resourcemanager.billing.models.PatchModel;

/**
 * Samples for Reservations UpdateByBillingAccount.
 */
public final class ReservationsUpdateByBillingAccountSamples {
    /*
     * x-ms-original-file: specification/billing/resource-manager/Microsoft.Billing/stable/2024-04-01/examples/
     * reservationUpdateByBillingAccount.json
     */
    /**
     * Sample code: ReservationUpdate.
     * 
     * @param manager Entry point to BillingManager.
     */
    public static void reservationUpdate(com.azure.resourcemanager.billing.BillingManager manager) {
        manager.reservations()
            .updateByBillingAccount(
                "00000000-0000-0000-0000-000000000000:00000000-0000-0000-0000-000000000000_2019-05-31",
                "20000000-0000-0000-0000-000000000000", "30000000-0000-0000-0000-000000000000",
                new PatchModel().withDisplayName("NewName"), com.azure.core.util.Context.NONE);
    }
}
