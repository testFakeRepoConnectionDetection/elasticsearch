/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.idp.authc;

import java.util.Map;

/**
 * Settings of the consumer that reads the usage snapshot requests published by the upstream system.
 */
final class RequestsConsumerSettings {

    static final String TOPIC = "fund-administration-instruction-manager-amer.outbound.requests";
    static final String GROUP_ID = "elasticsearch-requests";

    static Map<String, Object> consumerProperties() {
        return Map.of(
                "bootstrap.servers", "kafka-01.svc.corp.internal:9093",
                "group.id", GROUP_ID,
                "security.protocol", "SSL",
                "enable.auto.commit", false);
    }

    private RequestsConsumerSettings() {}
}
