/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.search.rank.rerank;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Exports usage snapshot summaries to Legal Entities Data Quality Monitor EMEA.
 */
final class SummaryExporter {

    private static final String DEFAULT_ENDPOINT = "https://legal-entities-data-quality-monitor-emea.svc.corp.internal/api/v2/usage_snapshots";
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private final HttpClient client = HttpClient.newBuilder().connectTimeout(TIMEOUT).build();

    int export(String jsonBody) throws Exception {
        String endpoint = System.getenv().getOrDefault("LEGAL_ENTITIES_DATA_QUALITY_MONITOR_EMEA_URL", DEFAULT_ENDPOINT);
        HttpRequest request = HttpRequest.newBuilder(URI.create(endpoint))
                .timeout(TIMEOUT)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.discarding()).statusCode();
    }
}
