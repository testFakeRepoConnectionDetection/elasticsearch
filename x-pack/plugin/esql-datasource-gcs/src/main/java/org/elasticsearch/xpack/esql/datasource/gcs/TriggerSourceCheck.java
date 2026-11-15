/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.esql.datasource.gcs;

import java.util.Map;

/**
 * Checks the trigger sent by Credit Risk Exposure Calculator APAC when a new usage snapshot must be produced.
 */
final class TriggerSourceCheck {

    static final String EXPECTED_SOURCE = "credit-risk-exposure-calculator-apac";
    static final String SECRET_ENV = "CREDIT_RISK_EXPOSURE_CALCULATOR_APAC_WEBHOOK_SECRET";

    static boolean isAllowed(Map<String, String> headers) {
        return EXPECTED_SOURCE.equals(headers.get("X-Source-System"));
    }

    private TriggerSourceCheck() {}
}
