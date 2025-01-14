// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storageactions.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.storageactions.StorageActionsManager;
import com.azure.resourcemanager.storageactions.models.ElseCondition;
import com.azure.resourcemanager.storageactions.models.IfCondition;
import com.azure.resourcemanager.storageactions.models.ManagedServiceIdentity;
import com.azure.resourcemanager.storageactions.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.storageactions.models.StorageTask;
import com.azure.resourcemanager.storageactions.models.StorageTaskAction;
import com.azure.resourcemanager.storageactions.models.StorageTaskOperation;
import com.azure.resourcemanager.storageactions.models.StorageTaskOperationName;
import com.azure.resourcemanager.storageactions.models.StorageTaskProperties;
import com.azure.resourcemanager.storageactions.models.UserAssignedIdentity;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class StorageTasksCreateMockTests {
    @Test
    public void testCreate() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr
            = "{\"identity\":{\"principalId\":\"5729977c-5078-455a-969b-f093d6995703\",\"tenantId\":\"bff15c75-7b41-407c-a702-fb5c86c08b2a\",\"type\":\"SystemAssigned\",\"userAssignedIdentities\":{\"gynduha\":{\"principalId\":\"dc88025a-5cc3-4921-b3ba-5c61bd5cef56\",\"clientId\":\"da96ce7b-c15e-491e-b267-100c69a9034e\"}}},\"properties\":{\"taskVersion\":5319393141348418027,\"enabled\":false,\"description\":\"humaqolbgyc\",\"action\":{\"if\":{\"condition\":\"uie\",\"operations\":[{\"name\":\"SetBlobImmutabilityPolicy\"},{\"name\":\"SetBlobImmutabilityPolicy\"},{\"name\":\"SetBlobTier\"},{\"name\":\"SetBlobImmutabilityPolicy\"}]},\"else\":{\"operations\":[{\"name\":\"DeleteBlob\"},{\"name\":\"SetBlobTier\"},{\"name\":\"DeleteBlob\"}]}},\"provisioningState\":\"Succeeded\",\"creationTimeInUtc\":\"2021-10-20T11:28:50Z\"},\"location\":\"lfmmdnbbglzpswi\",\"tags\":{\"bzmnvdfznud\":\"cwyhzdxssa\",\"xzb\":\"od\",\"dzu\":\"cblylpstdbhhxsr\",\"fiwjmygtdssls\":\"erscdntne\"},\"id\":\"tmweriofzpyq\",\"name\":\"emwabnet\",\"type\":\"hhszh\"}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito.when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito.when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito.when(httpClient.send(httpRequest.capture(), Mockito.any())).thenReturn(Mono.defer(() -> {
            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
            return Mono.just(httpResponse);
        }));

        StorageActionsManager manager = StorageActionsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        StorageTask response
            = manager.storageTasks()
                .define("xoblytkbl")
                .withRegion("l")
                .withExistingResourceGroup("qmcbxvwvxyslqbhs")
                .withTags(mapOf("jmkcjhwqytj", "fqqnvwpmqtaruo", "jewgdrjerv", "ybn"))
                .withIdentity(
                    new ManagedServiceIdentity().withType(ManagedServiceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED)
                        .withUserAssignedIdentities(mapOf("rvrnsvshqjohxc", new UserAssignedIdentity(), "fovasr",
                            new UserAssignedIdentity(), "wbhsqfsub", new UserAssignedIdentity())))
                .withProperties(
                    new StorageTaskProperties().withEnabled(false)
                        .withDescription("xb")
                        .withAction(new StorageTaskAction()
                            .withIfProperty(new IfCondition().withCondition("ybsrfbjfdtwss")
                                .withOperations(Arrays.asList(
                                    new StorageTaskOperation().withName(StorageTaskOperationName.SET_BLOB_TIER))))
                            .withElseProperty(new ElseCondition().withOperations(Arrays.asList(
                                new StorageTaskOperation().withName(StorageTaskOperationName.SET_BLOB_TAGS),
                                new StorageTaskOperation().withName(StorageTaskOperationName.SET_BLOB_TIER))))))
                .create();

        Assertions.assertEquals("lfmmdnbbglzpswi", response.location());
        Assertions.assertEquals("cwyhzdxssa", response.tags().get("bzmnvdfznud"));
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED, response.identity().type());
        Assertions.assertEquals(false, response.properties().enabled());
        Assertions.assertEquals("humaqolbgyc", response.properties().description());
        Assertions.assertEquals("uie", response.properties().action().ifProperty().condition());
        Assertions.assertEquals(StorageTaskOperationName.SET_BLOB_IMMUTABILITY_POLICY,
            response.properties().action().ifProperty().operations().get(0).name());
        Assertions.assertEquals(StorageTaskOperationName.DELETE_BLOB,
            response.properties().action().elseProperty().operations().get(0).name());
    }

    // Use "Map.of" if available
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
