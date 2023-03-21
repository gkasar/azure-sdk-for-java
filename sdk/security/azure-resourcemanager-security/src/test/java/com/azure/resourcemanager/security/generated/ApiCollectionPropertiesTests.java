// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.ApiCollectionProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ApiCollectionPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ApiCollectionProperties model =
            BinaryData
                .fromString(
                    "{\"displayName\":\"tgqztwhghmup\",\"additionalData\":{\"bklqpxz\":\"jtcdxabbujftaben\",\"nlzafwxudgnh\":\"cafeddw\",\"pbeme\":\"ookrtalvnbw\",\"kyrdnqodx\":\"uclvdjj\"}}")
                .toObject(ApiCollectionProperties.class);
        Assertions.assertEquals("tgqztwhghmup", model.displayName());
        Assertions.assertEquals("jtcdxabbujftaben", model.additionalData().get("bklqpxz"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ApiCollectionProperties model =
            new ApiCollectionProperties()
                .withDisplayName("tgqztwhghmup")
                .withAdditionalData(
                    mapOf(
                        "bklqpxz",
                        "jtcdxabbujftaben",
                        "nlzafwxudgnh",
                        "cafeddw",
                        "pbeme",
                        "ookrtalvnbw",
                        "kyrdnqodx",
                        "uclvdjj"));
        model = BinaryData.fromObject(model).toObject(ApiCollectionProperties.class);
        Assertions.assertEquals("tgqztwhghmup", model.displayName());
        Assertions.assertEquals("jtcdxabbujftaben", model.additionalData().get("bklqpxz"));
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}