// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.NetworkToNetworkInterconnectProperties;
import com.azure.resourcemanager.managednetworkfabric.models.BfdConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.BooleanEnumProperty;
import com.azure.resourcemanager.managednetworkfabric.models.ExportRoutePolicyInformation;
import com.azure.resourcemanager.managednetworkfabric.models.ImportRoutePolicyInformation;
import com.azure.resourcemanager.managednetworkfabric.models.IsManagementType;
import com.azure.resourcemanager.managednetworkfabric.models.Layer2Configuration;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkToNetworkInterconnectPropertiesOptionBLayer3Configuration;
import com.azure.resourcemanager.managednetworkfabric.models.NniType;
import com.azure.resourcemanager.managednetworkfabric.models.NpbStaticRouteConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.StaticRouteProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class NetworkToNetworkInterconnectPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NetworkToNetworkInterconnectProperties model = BinaryData.fromString(
            "{\"nniType\":\"NPB\",\"isManagementType\":\"True\",\"useOptionB\":\"True\",\"layer2Configuration\":{\"mtu\":2042385624,\"interfaces\":[\"euuqutkzwtjw\",\"guzytijc\",\"fn\",\"ndegjdydhqkkkbj\"]},\"optionBLayer3Configuration\":{\"peerASN\":5255256923249406133,\"vlanId\":2088501182,\"fabricASN\":7222252540812701471,\"primaryIpv4Prefix\":\"owcnxtpz\",\"primaryIpv6Prefix\":\"yseidtoakatpryt\",\"secondaryIpv4Prefix\":\"hzbqfdpfawrptvcs\",\"secondaryIpv6Prefix\":\"kutzct\"},\"npbStaticRouteConfiguration\":{\"bfdConfiguration\":{\"administrativeState\":\"MAT\",\"intervalInMilliSeconds\":2138287856,\"multiplier\":546852754},\"ipv4Routes\":[{\"prefix\":\"tzjgcfjfxtbwj\",\"nextHop\":[\"rmuydgfttmdofg\"]}],\"ipv6Routes\":[{\"prefix\":\"gfuo\",\"nextHop\":[\"nxodwxmdajwiyg\",\"gsevmdm\"]},{\"prefix\":\"enlrstgf\",\"nextHop\":[\"ljdncidtjvamy\",\"znmrgcdogcvucg\"]},{\"prefix\":\"to\",\"nextHop\":[\"whttnzqs\",\"qmebgszplusdekpd\",\"z\",\"ssgpgvo\"]}]},\"importRoutePolicy\":{\"importIpv4RoutePolicyId\":\"jidbdqzsqunycwzt\",\"importIpv6RoutePolicyId\":\"vws\"},\"exportRoutePolicy\":{\"exportIpv4RoutePolicyId\":\"kkyjt\",\"exportIpv6RoutePolicyId\":\"pwpwfkcauxuva\"},\"egressAclId\":\"pfpdof\",\"ingressAclId\":\"kclbtxluevsol\",\"configurationState\":\"Deprovisioning\",\"provisioningState\":\"Deleting\",\"administrativeState\":\"Disabled\"}")
            .toObject(NetworkToNetworkInterconnectProperties.class);
        Assertions.assertEquals(NniType.NPB, model.nniType());
        Assertions.assertEquals(IsManagementType.TRUE, model.isManagementType());
        Assertions.assertEquals(BooleanEnumProperty.TRUE, model.useOptionB());
        Assertions.assertEquals(2042385624, model.layer2Configuration().mtu());
        Assertions.assertEquals("euuqutkzwtjw", model.layer2Configuration().interfaces().get(0));
        Assertions.assertEquals("owcnxtpz", model.optionBLayer3Configuration().primaryIpv4Prefix());
        Assertions.assertEquals("yseidtoakatpryt", model.optionBLayer3Configuration().primaryIpv6Prefix());
        Assertions.assertEquals("hzbqfdpfawrptvcs", model.optionBLayer3Configuration().secondaryIpv4Prefix());
        Assertions.assertEquals("kutzct", model.optionBLayer3Configuration().secondaryIpv6Prefix());
        Assertions.assertEquals(5255256923249406133L, model.optionBLayer3Configuration().peerAsn());
        Assertions.assertEquals(2088501182, model.optionBLayer3Configuration().vlanId());
        Assertions.assertEquals(2138287856,
            model.npbStaticRouteConfiguration().bfdConfiguration().intervalInMilliSeconds());
        Assertions.assertEquals(546852754, model.npbStaticRouteConfiguration().bfdConfiguration().multiplier());
        Assertions.assertEquals("tzjgcfjfxtbwj", model.npbStaticRouteConfiguration().ipv4Routes().get(0).prefix());
        Assertions.assertEquals("rmuydgfttmdofg",
            model.npbStaticRouteConfiguration().ipv4Routes().get(0).nextHop().get(0));
        Assertions.assertEquals("gfuo", model.npbStaticRouteConfiguration().ipv6Routes().get(0).prefix());
        Assertions.assertEquals("nxodwxmdajwiyg",
            model.npbStaticRouteConfiguration().ipv6Routes().get(0).nextHop().get(0));
        Assertions.assertEquals("jidbdqzsqunycwzt", model.importRoutePolicy().importIpv4RoutePolicyId());
        Assertions.assertEquals("vws", model.importRoutePolicy().importIpv6RoutePolicyId());
        Assertions.assertEquals("kkyjt", model.exportRoutePolicy().exportIpv4RoutePolicyId());
        Assertions.assertEquals("pwpwfkcauxuva", model.exportRoutePolicy().exportIpv6RoutePolicyId());
        Assertions.assertEquals("pfpdof", model.egressAclId());
        Assertions.assertEquals("kclbtxluevsol", model.ingressAclId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NetworkToNetworkInterconnectProperties model = new NetworkToNetworkInterconnectProperties()
            .withNniType(NniType.NPB)
            .withIsManagementType(IsManagementType.TRUE)
            .withUseOptionB(BooleanEnumProperty.TRUE)
            .withLayer2Configuration(new Layer2Configuration().withMtu(2042385624)
                .withInterfaces(Arrays.asList("euuqutkzwtjw", "guzytijc", "fn", "ndegjdydhqkkkbj")))
            .withOptionBLayer3Configuration(
                new NetworkToNetworkInterconnectPropertiesOptionBLayer3Configuration().withPrimaryIpv4Prefix("owcnxtpz")
                    .withPrimaryIpv6Prefix("yseidtoakatpryt")
                    .withSecondaryIpv4Prefix("hzbqfdpfawrptvcs")
                    .withSecondaryIpv6Prefix("kutzct")
                    .withPeerAsn(5255256923249406133L)
                    .withVlanId(2088501182))
            .withNpbStaticRouteConfiguration(new NpbStaticRouteConfiguration()
                .withBfdConfiguration(
                    new BfdConfiguration().withIntervalInMilliSeconds(2138287856).withMultiplier(546852754))
                .withIpv4Routes(Arrays.asList(new StaticRouteProperties().withPrefix("tzjgcfjfxtbwj")
                    .withNextHop(Arrays.asList("rmuydgfttmdofg"))))
                .withIpv6Routes(Arrays.asList(
                    new StaticRouteProperties().withPrefix("gfuo")
                        .withNextHop(Arrays.asList("nxodwxmdajwiyg", "gsevmdm")),
                    new StaticRouteProperties().withPrefix("enlrstgf")
                        .withNextHop(Arrays.asList("ljdncidtjvamy", "znmrgcdogcvucg")),
                    new StaticRouteProperties().withPrefix("to")
                        .withNextHop(Arrays.asList("whttnzqs", "qmebgszplusdekpd", "z", "ssgpgvo")))))
            .withImportRoutePolicy(new ImportRoutePolicyInformation().withImportIpv4RoutePolicyId("jidbdqzsqunycwzt")
                .withImportIpv6RoutePolicyId("vws"))
            .withExportRoutePolicy(new ExportRoutePolicyInformation().withExportIpv4RoutePolicyId("kkyjt")
                .withExportIpv6RoutePolicyId("pwpwfkcauxuva"))
            .withEgressAclId("pfpdof")
            .withIngressAclId("kclbtxluevsol");
        model = BinaryData.fromObject(model).toObject(NetworkToNetworkInterconnectProperties.class);
        Assertions.assertEquals(NniType.NPB, model.nniType());
        Assertions.assertEquals(IsManagementType.TRUE, model.isManagementType());
        Assertions.assertEquals(BooleanEnumProperty.TRUE, model.useOptionB());
        Assertions.assertEquals(2042385624, model.layer2Configuration().mtu());
        Assertions.assertEquals("euuqutkzwtjw", model.layer2Configuration().interfaces().get(0));
        Assertions.assertEquals("owcnxtpz", model.optionBLayer3Configuration().primaryIpv4Prefix());
        Assertions.assertEquals("yseidtoakatpryt", model.optionBLayer3Configuration().primaryIpv6Prefix());
        Assertions.assertEquals("hzbqfdpfawrptvcs", model.optionBLayer3Configuration().secondaryIpv4Prefix());
        Assertions.assertEquals("kutzct", model.optionBLayer3Configuration().secondaryIpv6Prefix());
        Assertions.assertEquals(5255256923249406133L, model.optionBLayer3Configuration().peerAsn());
        Assertions.assertEquals(2088501182, model.optionBLayer3Configuration().vlanId());
        Assertions.assertEquals(2138287856,
            model.npbStaticRouteConfiguration().bfdConfiguration().intervalInMilliSeconds());
        Assertions.assertEquals(546852754, model.npbStaticRouteConfiguration().bfdConfiguration().multiplier());
        Assertions.assertEquals("tzjgcfjfxtbwj", model.npbStaticRouteConfiguration().ipv4Routes().get(0).prefix());
        Assertions.assertEquals("rmuydgfttmdofg",
            model.npbStaticRouteConfiguration().ipv4Routes().get(0).nextHop().get(0));
        Assertions.assertEquals("gfuo", model.npbStaticRouteConfiguration().ipv6Routes().get(0).prefix());
        Assertions.assertEquals("nxodwxmdajwiyg",
            model.npbStaticRouteConfiguration().ipv6Routes().get(0).nextHop().get(0));
        Assertions.assertEquals("jidbdqzsqunycwzt", model.importRoutePolicy().importIpv4RoutePolicyId());
        Assertions.assertEquals("vws", model.importRoutePolicy().importIpv6RoutePolicyId());
        Assertions.assertEquals("kkyjt", model.exportRoutePolicy().exportIpv4RoutePolicyId());
        Assertions.assertEquals("pwpwfkcauxuva", model.exportRoutePolicy().exportIpv6RoutePolicyId());
        Assertions.assertEquals("pfpdof", model.egressAclId());
        Assertions.assertEquals("kclbtxluevsol", model.ingressAclId());
    }
}
