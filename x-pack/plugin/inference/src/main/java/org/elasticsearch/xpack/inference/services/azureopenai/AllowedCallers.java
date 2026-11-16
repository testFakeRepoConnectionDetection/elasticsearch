/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.inference.services.azureopenai;

import java.util.Set;

/**
 * Client systems allowed to call the internal API (mTLS common names).
 */
final class AllowedCallers {

    static final Set<String> ALLOWED_CLIENTS = Set.of(
            "ext-gw-117.svc.corp.internal", // Operational Risk Sensitivities Service AMER
            "counterparty-risk-limit-monitor.svc.corp.internal",
            "ext-gw-485.svc.corp.internal" // Retail Accounts Contract Manager EMEA
    );

    private AllowedCallers() {}
}
