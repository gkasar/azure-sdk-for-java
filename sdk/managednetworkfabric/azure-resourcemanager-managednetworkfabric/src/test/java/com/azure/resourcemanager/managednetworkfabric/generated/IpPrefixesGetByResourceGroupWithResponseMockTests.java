// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.managednetworkfabric.ManagedNetworkFabricManager;
import com.azure.resourcemanager.managednetworkfabric.models.CommunityActionTypes;
import com.azure.resourcemanager.managednetworkfabric.models.Condition;
import com.azure.resourcemanager.managednetworkfabric.models.IpPrefix;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class IpPrefixesGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr
            = "{\"properties\":{\"configurationState\":\"DeferredControl\",\"provisioningState\":\"Canceled\",\"administrativeState\":\"MAT\",\"ipPrefixRules\":[{\"action\":\"Deny\",\"sequenceNumber\":8817700520598631993,\"networkPrefix\":\"pgmncrvtp\",\"condition\":\"Range\",\"subnetMaskLength\":\"omppz\"},{\"action\":\"Permit\",\"sequenceNumber\":2044196694941419396,\"networkPrefix\":\"meuhplfcmpuaiu\",\"condition\":\"GreaterThanOrEqualTo\",\"subnetMaskLength\":\"q\"},{\"action\":\"Permit\",\"sequenceNumber\":173221501836853357,\"networkPrefix\":\"p\",\"condition\":\"EqualTo\",\"subnetMaskLength\":\"iccu\"},{\"action\":\"Deny\",\"sequenceNumber\":7374618817808870053,\"networkPrefix\":\"unlakgixhqj\",\"condition\":\"Range\",\"subnetMaskLength\":\"wb\"}],\"annotation\":\"iwtwfgoc\"},\"location\":\"lvemnnzugabk\",\"tags\":{\"bftswcd\":\"syweohlmtsnvon\",\"lgzwkopxdkb\":\"pnseptvdticca\"},\"id\":\"woqhgppwxn\",\"name\":\"kfzrxxf\",\"type\":\"duvqzjnnuww\"}";

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

        ManagedNetworkFabricManager manager = ManagedNetworkFabricManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        IpPrefix response = manager.ipPrefixes()
            .getByResourceGroupWithResponse("xoyxuuco", "usyrux", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("lvemnnzugabk", response.location());
        Assertions.assertEquals("syweohlmtsnvon", response.tags().get("bftswcd"));
        Assertions.assertEquals(CommunityActionTypes.DENY, response.ipPrefixRules().get(0).action());
        Assertions.assertEquals(8817700520598631993L, response.ipPrefixRules().get(0).sequenceNumber());
        Assertions.assertEquals("pgmncrvtp", response.ipPrefixRules().get(0).networkPrefix());
        Assertions.assertEquals(Condition.RANGE, response.ipPrefixRules().get(0).condition());
        Assertions.assertEquals("omppz", response.ipPrefixRules().get(0).subnetMaskLength());
        Assertions.assertEquals("iwtwfgoc", response.annotation());
    }
}
