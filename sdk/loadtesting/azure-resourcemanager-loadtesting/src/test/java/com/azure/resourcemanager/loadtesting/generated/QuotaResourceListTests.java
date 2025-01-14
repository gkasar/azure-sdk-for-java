// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loadtesting.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.loadtesting.models.QuotaResourceList;
import org.junit.jupiter.api.Test;

public final class QuotaResourceListTests {
    @Test
    public void testDeserialize() throws Exception {
        QuotaResourceList model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"limit\":437058664,\"usage\":1438180551,\"provisioningState\":\"Succeeded\"},\"id\":\"bifpikxwczb\",\"name\":\"scnpqxuhivy\",\"type\":\"n\"}],\"nextLink\":\"b\"}")
            .toObject(QuotaResourceList.class);
    }

    @Test
    public void testSerialize() throws Exception {
        QuotaResourceList model = new QuotaResourceList();
        model = BinaryData.fromObject(model).toObject(QuotaResourceList.class);
    }
}
