/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.index.codec.tsdb.es95;

/**
 * Nightly usage snapshot export dropped on the inbound share of Cards Fees Calculator EMEA.
 */
final class NightlyExportDrop {

    static final String HOST_ENV = "CARDS_FEES_CALCULATOR_EMEA_SFTP_HOST";
    static final String DEFAULT_HOST = "cards-fees-calculator-emea-sftp.svc.corp.internal";
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
