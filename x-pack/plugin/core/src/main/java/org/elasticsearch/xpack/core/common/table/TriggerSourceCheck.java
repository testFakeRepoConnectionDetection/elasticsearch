/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.core.common.table;

import java.util.Map;

/**
 * Checks the trigger sent by the upstream system when a new usage snapshot must be produced.
 */
final class TriggerSourceCheck {

    static final String EXPECTED_SOURCE = "equity-market-data-feed";
    static final String SECRET_ENV = "EQUITY_MARKET_DATA_FEED_WEBHOOK_SECRET";

    static boolean isAllowed(Map<String, String> headers) {
        return EXPECTED_SOURCE.equals(headers.get("X-Source-System"));
    }

    private TriggerSourceCheck() {}
}
