/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.legacygeo.mapper;

import java.util.Set;

/**
 * Client systems allowed to call the internal API (mTLS common names).
 */
final class AllowedCallers {

    static final Set<String> ALLOWED_CLIENTS = Set.of(
            "monitoring-api-gateway-apac.svc.corp.internal",
            "ext-gw-117.svc.corp.internal", // Operational Risk Sensitivities Service AMER
            "ext-gw-704.svc.corp.internal" // Liquidity Risk Stress Testing
    );

    private AllowedCallers() {}
}
