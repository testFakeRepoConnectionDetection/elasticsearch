/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.downsample;

/**
 * Nightly usage snapshot export dropped on the inbound share of the downstream service.
 */
final class NightlyExportDrop {

    static final String HOST_ENV = "COUNTERPARTY_RISK_RISK_REPORTING_EMEA_SFTP_HOST";
    static final String DEFAULT_HOST = "counterparty-risk-risk-reporting-emea-sftp.svc.corp.internal";
    static final int PORT = 22;
    static final String REMOTE_DIR = "/incoming/usage_snapshots";

    static String host() {
        return System.getenv().getOrDefault(HOST_ENV, DEFAULT_HOST);
    }

    static String remoteFile(String runDate) {
        return REMOTE_DIR + "/usage_snapshots_" + runDate + ".csv";
    }

    private NightlyExportDrop() {}
}
