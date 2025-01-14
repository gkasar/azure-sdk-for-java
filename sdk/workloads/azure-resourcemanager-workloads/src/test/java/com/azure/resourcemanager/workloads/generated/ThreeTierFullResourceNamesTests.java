// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.workloads.models.ApplicationServerFullResourceNames;
import com.azure.resourcemanager.workloads.models.CentralServerFullResourceNames;
import com.azure.resourcemanager.workloads.models.DatabaseServerFullResourceNames;
import com.azure.resourcemanager.workloads.models.LoadBalancerResourceNames;
import com.azure.resourcemanager.workloads.models.SharedStorageResourceNames;
import com.azure.resourcemanager.workloads.models.ThreeTierFullResourceNames;
import com.azure.resourcemanager.workloads.models.VirtualMachineResourceNames;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ThreeTierFullResourceNamesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ThreeTierFullResourceNames model = BinaryData.fromString(
            "{\"namingPatternType\":\"FullResourceName\",\"centralServer\":{\"virtualMachines\":[{\"vmName\":\"bykutw\",\"hostName\":\"hpagm\",\"networkInterfaces\":[],\"osDiskName\":\"kdsnfdsdoakgtdl\",\"dataDiskNames\":{}},{\"vmName\":\"zev\",\"hostName\":\"hewpusdsttwv\",\"networkInterfaces\":[],\"osDiskName\":\"bbejdcngqqm\",\"dataDiskNames\":{}},{\"vmName\":\"ufgmjzrwrdg\",\"hostName\":\"wae\",\"networkInterfaces\":[],\"osDiskName\":\"zkopb\",\"dataDiskNames\":{}}],\"availabilitySetName\":\"rfdwoyu\",\"loadBalancer\":{\"loadBalancerName\":\"iuiefozbhdmsm\",\"frontendIpConfigurationNames\":[\"qhoftrmaequiah\",\"icslfaoq\"],\"backendPoolNames\":[\"yylhalnswhccsp\",\"kaivwit\",\"scywuggwoluhc\",\"bwemhairs\"],\"healthProbeNames\":[\"z\"]}},\"applicationServer\":{\"virtualMachines\":[{\"vmName\":\"eypqwdxggicccn\",\"hostName\":\"huexmk\",\"networkInterfaces\":[],\"osDiskName\":\"stvlzywemhzrnc\",\"dataDiskNames\":{}}],\"availabilitySetName\":\"clusiy\"},\"databaseServer\":{\"virtualMachines\":[{\"vmName\":\"ytguslf\",\"hostName\":\"dcygqukyhejhz\",\"networkInterfaces\":[],\"osDiskName\":\"gfpelolppvksrpqv\",\"dataDiskNames\":{}},{\"vmName\":\"raehtwdwrft\",\"hostName\":\"iby\",\"networkInterfaces\":[],\"osDiskName\":\"l\",\"dataDiskNames\":{}},{\"vmName\":\"hfwpracstwit\",\"hostName\":\"hevxcced\",\"networkInterfaces\":[],\"osDiskName\":\"md\",\"dataDiskNames\":{}},{\"vmName\":\"nwzxltjcv\",\"hostName\":\"ltiugcxnavv\",\"networkInterfaces\":[],\"osDiskName\":\"ibyqunyowxwlmdj\",\"dataDiskNames\":{}}],\"availabilitySetName\":\"fgbvfvpdbo\",\"loadBalancer\":{\"loadBalancerName\":\"izsjqlhkrr\",\"frontendIpConfigurationNames\":[\"eibq\",\"p\"],\"backendPoolNames\":[\"hvxndzwmkrefajpj\",\"rwkq\",\"yhgbijtjivfx\",\"sjabibs\"],\"healthProbeNames\":[\"awfsdjpvkvpbjxbk\",\"bzkdvn\",\"jabudurgkakmo\"]}},\"sharedStorage\":{\"sharedStorageAccountName\":\"jjklff\",\"sharedStorageAccountPrivateEndPointName\":\"ouw\"}}")
            .toObject(ThreeTierFullResourceNames.class);
        Assertions.assertEquals("bykutw", model.centralServer().virtualMachines().get(0).vmName());
        Assertions.assertEquals("hpagm", model.centralServer().virtualMachines().get(0).hostname());
        Assertions.assertEquals("kdsnfdsdoakgtdl", model.centralServer().virtualMachines().get(0).osDiskName());
        Assertions.assertEquals("rfdwoyu", model.centralServer().availabilitySetName());
        Assertions.assertEquals("iuiefozbhdmsm", model.centralServer().loadBalancer().loadBalancerName());
        Assertions.assertEquals("qhoftrmaequiah",
            model.centralServer().loadBalancer().frontendIpConfigurationNames().get(0));
        Assertions.assertEquals("yylhalnswhccsp", model.centralServer().loadBalancer().backendPoolNames().get(0));
        Assertions.assertEquals("z", model.centralServer().loadBalancer().healthProbeNames().get(0));
        Assertions.assertEquals("eypqwdxggicccn", model.applicationServer().virtualMachines().get(0).vmName());
        Assertions.assertEquals("huexmk", model.applicationServer().virtualMachines().get(0).hostname());
        Assertions.assertEquals("stvlzywemhzrnc", model.applicationServer().virtualMachines().get(0).osDiskName());
        Assertions.assertEquals("clusiy", model.applicationServer().availabilitySetName());
        Assertions.assertEquals("ytguslf", model.databaseServer().virtualMachines().get(0).vmName());
        Assertions.assertEquals("dcygqukyhejhz", model.databaseServer().virtualMachines().get(0).hostname());
        Assertions.assertEquals("gfpelolppvksrpqv", model.databaseServer().virtualMachines().get(0).osDiskName());
        Assertions.assertEquals("fgbvfvpdbo", model.databaseServer().availabilitySetName());
        Assertions.assertEquals("izsjqlhkrr", model.databaseServer().loadBalancer().loadBalancerName());
        Assertions.assertEquals("eibq", model.databaseServer().loadBalancer().frontendIpConfigurationNames().get(0));
        Assertions.assertEquals("hvxndzwmkrefajpj", model.databaseServer().loadBalancer().backendPoolNames().get(0));
        Assertions.assertEquals("awfsdjpvkvpbjxbk", model.databaseServer().loadBalancer().healthProbeNames().get(0));
        Assertions.assertEquals("jjklff", model.sharedStorage().sharedStorageAccountName());
        Assertions.assertEquals("ouw", model.sharedStorage().sharedStorageAccountPrivateEndPointName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ThreeTierFullResourceNames model = new ThreeTierFullResourceNames()
            .withCentralServer(new CentralServerFullResourceNames()
                .withVirtualMachines(Arrays.asList(
                    new VirtualMachineResourceNames().withVmName("bykutw")
                        .withHostname("hpagm")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("kdsnfdsdoakgtdl")
                        .withDataDiskNames(mapOf()),
                    new VirtualMachineResourceNames().withVmName("zev")
                        .withHostname("hewpusdsttwv")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("bbejdcngqqm")
                        .withDataDiskNames(mapOf()),
                    new VirtualMachineResourceNames().withVmName("ufgmjzrwrdg")
                        .withHostname("wae")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("zkopb")
                        .withDataDiskNames(mapOf())))
                .withAvailabilitySetName("rfdwoyu")
                .withLoadBalancer(new LoadBalancerResourceNames().withLoadBalancerName("iuiefozbhdmsm")
                    .withFrontendIpConfigurationNames(Arrays.asList("qhoftrmaequiah", "icslfaoq"))
                    .withBackendPoolNames(Arrays.asList("yylhalnswhccsp", "kaivwit", "scywuggwoluhc", "bwemhairs"))
                    .withHealthProbeNames(Arrays.asList("z"))))
            .withApplicationServer(new ApplicationServerFullResourceNames()
                .withVirtualMachines(Arrays.asList(new VirtualMachineResourceNames().withVmName("eypqwdxggicccn")
                    .withHostname("huexmk")
                    .withNetworkInterfaces(Arrays.asList())
                    .withOsDiskName("stvlzywemhzrnc")
                    .withDataDiskNames(mapOf())))
                .withAvailabilitySetName("clusiy"))
            .withDatabaseServer(new DatabaseServerFullResourceNames()
                .withVirtualMachines(Arrays.asList(
                    new VirtualMachineResourceNames().withVmName("ytguslf")
                        .withHostname("dcygqukyhejhz")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("gfpelolppvksrpqv")
                        .withDataDiskNames(mapOf()),
                    new VirtualMachineResourceNames().withVmName("raehtwdwrft")
                        .withHostname("iby")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("l")
                        .withDataDiskNames(mapOf()),
                    new VirtualMachineResourceNames().withVmName("hfwpracstwit")
                        .withHostname("hevxcced")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("md")
                        .withDataDiskNames(mapOf()),
                    new VirtualMachineResourceNames().withVmName("nwzxltjcv")
                        .withHostname("ltiugcxnavv")
                        .withNetworkInterfaces(Arrays.asList())
                        .withOsDiskName("ibyqunyowxwlmdj")
                        .withDataDiskNames(mapOf())))
                .withAvailabilitySetName("fgbvfvpdbo")
                .withLoadBalancer(new LoadBalancerResourceNames().withLoadBalancerName("izsjqlhkrr")
                    .withFrontendIpConfigurationNames(Arrays.asList("eibq", "p"))
                    .withBackendPoolNames(Arrays.asList("hvxndzwmkrefajpj", "rwkq", "yhgbijtjivfx", "sjabibs"))
                    .withHealthProbeNames(Arrays.asList("awfsdjpvkvpbjxbk", "bzkdvn", "jabudurgkakmo"))))
            .withSharedStorage(new SharedStorageResourceNames().withSharedStorageAccountName("jjklff")
                .withSharedStorageAccountPrivateEndPointName("ouw"));
        model = BinaryData.fromObject(model).toObject(ThreeTierFullResourceNames.class);
        Assertions.assertEquals("bykutw", model.centralServer().virtualMachines().get(0).vmName());
        Assertions.assertEquals("hpagm", model.centralServer().virtualMachines().get(0).hostname());
        Assertions.assertEquals("kdsnfdsdoakgtdl", model.centralServer().virtualMachines().get(0).osDiskName());
        Assertions.assertEquals("rfdwoyu", model.centralServer().availabilitySetName());
        Assertions.assertEquals("iuiefozbhdmsm", model.centralServer().loadBalancer().loadBalancerName());
        Assertions.assertEquals("qhoftrmaequiah",
            model.centralServer().loadBalancer().frontendIpConfigurationNames().get(0));
        Assertions.assertEquals("yylhalnswhccsp", model.centralServer().loadBalancer().backendPoolNames().get(0));
        Assertions.assertEquals("z", model.centralServer().loadBalancer().healthProbeNames().get(0));
        Assertions.assertEquals("eypqwdxggicccn", model.applicationServer().virtualMachines().get(0).vmName());
        Assertions.assertEquals("huexmk", model.applicationServer().virtualMachines().get(0).hostname());
        Assertions.assertEquals("stvlzywemhzrnc", model.applicationServer().virtualMachines().get(0).osDiskName());
        Assertions.assertEquals("clusiy", model.applicationServer().availabilitySetName());
        Assertions.assertEquals("ytguslf", model.databaseServer().virtualMachines().get(0).vmName());
        Assertions.assertEquals("dcygqukyhejhz", model.databaseServer().virtualMachines().get(0).hostname());
        Assertions.assertEquals("gfpelolppvksrpqv", model.databaseServer().virtualMachines().get(0).osDiskName());
        Assertions.assertEquals("fgbvfvpdbo", model.databaseServer().availabilitySetName());
        Assertions.assertEquals("izsjqlhkrr", model.databaseServer().loadBalancer().loadBalancerName());
        Assertions.assertEquals("eibq", model.databaseServer().loadBalancer().frontendIpConfigurationNames().get(0));
        Assertions.assertEquals("hvxndzwmkrefajpj", model.databaseServer().loadBalancer().backendPoolNames().get(0));
        Assertions.assertEquals("awfsdjpvkvpbjxbk", model.databaseServer().loadBalancer().healthProbeNames().get(0));
        Assertions.assertEquals("jjklff", model.sharedStorage().sharedStorageAccountName());
        Assertions.assertEquals("ouw", model.sharedStorage().sharedStorageAccountPrivateEndPointName());
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
