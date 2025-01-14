// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.digitaltwins.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsDescription;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsIdentityType;
import com.azure.resourcemanager.digitaltwins.models.PublicNetworkAccess;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class DigitalTwinsListMockTests {
    @Test
    public void testList() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr
            = "{\"value\":[{\"properties\":{\"createdTime\":\"2021-04-27T01:09:59Z\",\"lastUpdatedTime\":\"2021-06-10T13:25:17Z\",\"provisioningState\":\"Failed\",\"hostName\":\"twrupqsxvnm\",\"privateEndpointConnections\":[],\"publicNetworkAccess\":\"Enabled\"},\"identity\":{\"type\":\"None\",\"principalId\":\"eil\",\"tenantId\":\"notyfjfcnjbkcn\",\"userAssignedIdentities\":{}},\"location\":\"ttkphywpnvjtoqne\",\"tags\":{\"oxuscrpabgyepsbj\":\"lfplp\"},\"id\":\"azqugxywpmueefj\",\"name\":\"wfqkquj\",\"type\":\"dsuyonobgla\"}]}";

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

        AzureDigitalTwinsManager manager = AzureDigitalTwinsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<DigitalTwinsDescription> response = manager.digitalTwins().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("ttkphywpnvjtoqne", response.iterator().next().location());
        Assertions.assertEquals("lfplp", response.iterator().next().tags().get("oxuscrpabgyepsbj"));
        Assertions.assertEquals(DigitalTwinsIdentityType.NONE, response.iterator().next().identity().type());
        Assertions.assertEquals(PublicNetworkAccess.ENABLED, response.iterator().next().publicNetworkAccess());
    }
}
