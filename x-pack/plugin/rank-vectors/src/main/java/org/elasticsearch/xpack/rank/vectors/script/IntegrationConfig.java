/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.xpack.rank.vectors.script;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 * Reads the integration endpoints from integrations.yml; only the keys are known here.
 */
final class IntegrationConfig {

    static final String CONFIG_PATH = "/etc/corp/integrations.yml";
    static final String[] KEYS = {"incident_hook", "alert_forward", "metrics_relay"};

    static Map<String, Object> load() throws IOException {
        try (InputStream in = Files.newInputStream(Path.of(CONFIG_PATH))) {
            Map<String, Object> root = new Yaml().load(in);
            return root;
        }
    }

    private IntegrationConfig() {}
}
