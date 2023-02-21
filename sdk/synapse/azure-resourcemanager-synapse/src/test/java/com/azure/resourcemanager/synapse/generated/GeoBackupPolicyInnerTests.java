// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.GeoBackupPolicyInner;
import com.azure.resourcemanager.synapse.models.GeoBackupPolicyState;
import org.junit.jupiter.api.Assertions;

public final class GeoBackupPolicyInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GeoBackupPolicyInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"state\":\"Enabled\",\"storageType\":\"sd\"},\"kind\":\"ouwaboekqvkeln\",\"location\":\"vbxwyjsflhh\",\"id\":\"aalnjixi\",\"name\":\"xyawj\",\"type\":\"yaqcslyjpkiidz\"}")
                .toObject(GeoBackupPolicyInner.class);
        Assertions.assertEquals(GeoBackupPolicyState.ENABLED, model.state());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GeoBackupPolicyInner model = new GeoBackupPolicyInner().withState(GeoBackupPolicyState.ENABLED);
        model = BinaryData.fromObject(model).toObject(GeoBackupPolicyInner.class);
        Assertions.assertEquals(GeoBackupPolicyState.ENABLED, model.state());
    }
}