// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.LibraryResourceInner;
import org.junit.jupiter.api.Assertions;

public final class LibraryResourceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LibraryResourceInner model = BinaryData.fromString(
            "{\"properties\":{\"name\":\"eiknpgo\",\"path\":\"jiuqhibtozi\",\"containerName\":\"wjedmurrxxgew\",\"uploadedTimestamp\":\"2021-06-22T20:24:57Z\",\"type\":\"ylkmqp\",\"provisioningStatus\":\"yhlfb\",\"creatorId\":\"wgcloxoebqinji\"},\"etag\":\"wjfuj\",\"id\":\"lafcbahh\",\"name\":\"zpofoiyjwpfilk\",\"type\":\"kkholvdndvia\"}")
            .toObject(LibraryResourceInner.class);
        Assertions.assertEquals("eiknpgo", model.namePropertiesName());
        Assertions.assertEquals("jiuqhibtozi", model.path());
        Assertions.assertEquals("wjedmurrxxgew", model.containerName());
        Assertions.assertEquals("ylkmqp", model.typePropertiesType());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LibraryResourceInner model = new LibraryResourceInner().withNamePropertiesName("eiknpgo")
            .withPath("jiuqhibtozi")
            .withContainerName("wjedmurrxxgew")
            .withTypePropertiesType("ylkmqp");
        model = BinaryData.fromObject(model).toObject(LibraryResourceInner.class);
        Assertions.assertEquals("eiknpgo", model.namePropertiesName());
        Assertions.assertEquals("jiuqhibtozi", model.path());
        Assertions.assertEquals("wjedmurrxxgew", model.containerName());
        Assertions.assertEquals("ylkmqp", model.typePropertiesType());
    }
}
