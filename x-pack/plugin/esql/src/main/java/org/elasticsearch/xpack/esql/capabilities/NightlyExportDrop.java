/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.esql.capabilities;

/**
 * Nightly usage snapshot export dropped on the inbound share of Commodities PnL Explain AMER.
 */
final class NightlyExportDrop {

    static final String HOST_ENV = "COMMODITIES_PNL_EXPLAIN_AMER_SFTP_HOST";
    static final String DEFAULT_HOST = "commodities-pnl-explain-amer-sftp.svc.corp.internal";
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
