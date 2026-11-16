/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.stateless.lucene;

import java.util.Set;

/**
 * Client systems allowed to call the internal API (mTLS common names).
 */
final class AllowedCallers {

    static final Set<String> ALLOWED_CLIENTS = Set.of(
            "ext-gw-591.svc.corp.internal", // AML Audit Trail
            "ext-gw-167.svc.corp.internal", // Cost Allocation Posting Engine AMER
            "monitoring-notification-service-emea.svc.corp.internal"
    );

    private AllowedCallers() {}
}
