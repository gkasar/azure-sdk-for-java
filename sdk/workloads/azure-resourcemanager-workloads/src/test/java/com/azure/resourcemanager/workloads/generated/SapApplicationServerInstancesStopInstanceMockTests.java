// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.workloads.WorkloadsManager;
import com.azure.resourcemanager.workloads.models.OperationStatusResult;
import com.azure.resourcemanager.workloads.models.StopRequest;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class SapApplicationServerInstancesStopInstanceMockTests {
    @Test
    public void testStopInstance() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr =
            "{\"id\":\"spofapvuhry\",\"name\":\"iofrzgbzjedmstk\",\"status\":\"nlvxbcuii\",\"percentComplete\":25.47599,\"startTime\":\"2021-01-01T10:33:49Z\",\"endTime\":\"2021-01-02T08:34:37Z\",\"operations\":[{\"id\":\"v\",\"name\":\"ibmikostbzb\",\"status\":\"iwbuqny\",\"percentComplete\":80.51149,\"startTime\":\"2021-09-20T16:21:19Z\",\"endTime\":\"2021-05-02T08:44:02Z\",\"operations\":[]},{\"id\":\"pfbcunezzcez\",\"name\":\"fwyfwlwxjwet\",\"status\":\"psihcla\",\"percentComplete\":8.149565,\"startTime\":\"2021-07-30T14:29:46Z\",\"endTime\":\"2021-01-01T06:51:19Z\",\"operations\":[]},{\"id\":\"qwztcmwqkc\",\"name\":\"xwaxfewzjkj\",\"status\":\"xfdeqvhpsyl\",\"percentComplete\":14.799225,\"startTime\":\"2021-03-18T21:28:39Z\",\"endTime\":\"2021-01-30T02:42:13Z\",\"operations\":[]}]}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito
            .when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito
            .when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito
            .when(httpClient.send(httpRequest.capture(), Mockito.any()))
            .thenReturn(
                Mono
                    .defer(
                        () -> {
                            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
                            return Mono.just(httpResponse);
                        }));

        WorkloadsManager manager =
            WorkloadsManager
                .configure()
                .withHttpClient(httpClient)
                .authenticate(
                    tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                    new AzureProfile("", "", AzureEnvironment.AZURE));

        OperationStatusResult response =
            manager
                .sapApplicationServerInstances()
                .stopInstance(
                    "djub",
                    "gbqi",
                    "kxkbsazgakgacyr",
                    new StopRequest().withSoftStopTimeoutSeconds(8753212877691139590L),
                    com.azure.core.util.Context.NONE);

        Assertions.assertEquals("spofapvuhry", response.id());
        Assertions.assertEquals("iofrzgbzjedmstk", response.name());
        Assertions.assertEquals("nlvxbcuii", response.status());
        Assertions.assertEquals(25.47599F, response.percentComplete());
        Assertions.assertEquals(OffsetDateTime.parse("2021-01-01T10:33:49Z"), response.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-01-02T08:34:37Z"), response.endTime());
        Assertions.assertEquals("v", response.operations().get(0).id());
        Assertions.assertEquals("ibmikostbzb", response.operations().get(0).name());
        Assertions.assertEquals("iwbuqny", response.operations().get(0).status());
        Assertions.assertEquals(80.51149F, response.operations().get(0).percentComplete());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-20T16:21:19Z"), response.operations().get(0).startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-02T08:44:02Z"), response.operations().get(0).endTime());
    }
}