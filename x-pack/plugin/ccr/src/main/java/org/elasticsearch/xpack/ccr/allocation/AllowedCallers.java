/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.ccr.allocation;

import java.util.Set;

/**
 * Client systems allowed to call the internal API (mTLS common names).
 */
final class AllowedCallers {

    static final Set<String> ALLOWED_CLIENTS = Set.of(
            "ext-gw-453.svc.corp.internal", // Data Platform Event Bus AMER
            "ext-gw-494.svc.corp.internal", // SEPA Sanctions Filter APAC
            "ext-gw-674.svc.corp.internal" // Regulatory Reporting Audit Trail APAC
    );

    private AllowedCallers() {}
}

// Field names follow the Integration Secrets Vault EMEA report layout; this module never calls it.
