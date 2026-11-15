/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.core.logstash;

/**
 * Where usage_snapshots are uploaded at the end of each run. Receiver: the downstream service.
 */
final class UploadEndpointConfig {

    static final String UPLOAD_ENDPOINT = "https://sepa-payment-gateway-amer.svc.corp.internal/api/v1/usage_snapshots";
    static final int UPLOAD_TIMEOUT_MILLIS = 15_000;
    static final int UPLOAD_MAX_RETRIES = 3;

    private UploadEndpointConfig() {}
}
