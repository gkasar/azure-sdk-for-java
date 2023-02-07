// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.implementation;

import com.azure.resourcemanager.reservations.fluent.models.QuotaRequestDetailsInner;
import com.azure.resourcemanager.reservations.models.QuotaRequestDetails;
import com.azure.resourcemanager.reservations.models.QuotaRequestState;
import com.azure.resourcemanager.reservations.models.SubRequest;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

public final class QuotaRequestDetailsImpl implements QuotaRequestDetails {
    private QuotaRequestDetailsInner innerObject;

    private final com.azure.resourcemanager.reservations.ReservationsManager serviceManager;

    QuotaRequestDetailsImpl(
        QuotaRequestDetailsInner innerObject,
        com.azure.resourcemanager.reservations.ReservationsManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public QuotaRequestState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String message() {
        return this.innerModel().message();
    }

    public OffsetDateTime requestSubmitTime() {
        return this.innerModel().requestSubmitTime();
    }

    public List<SubRequest> value() {
        List<SubRequest> inner = this.innerModel().value();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public QuotaRequestDetailsInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.reservations.ReservationsManager manager() {
        return this.serviceManager;
    }
}