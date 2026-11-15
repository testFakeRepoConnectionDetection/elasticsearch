/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.core.template;

import java.util.Map;

/**
 * Settings of the producer that publishes usage snapshot events for the downstream service.
 */
final class EventsProducerSettings {

    static final String BOOTSTRAP_SERVERS = "kafka-01.svc.corp.internal:9093";
    static final String TOPIC = "app-ap10626.inbound.usage_snapshots";

    static Map<String, Object> producerProperties() {
        return Map.of(
                "bootstrap.servers", BOOTSTRAP_SERVERS,
                "security.protocol", "SSL",
                "acks", "all",
                "linger.ms", 50);
    }

    private EventsProducerSettings() {}
}
