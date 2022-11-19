package com.srs.common.config;

import java.util.Map;


public abstract class BaseServiceConfig {
    protected final Map<String, String> configMap;

    protected BaseServiceConfig(BaseServiceConfigLoader configLoader, String configTable) {
        this.configMap = configLoader.load(configTable);
        this.parse();
    }

    /**
     * Parse configMap into service-specific DTO
     */
    protected abstract void parse();
}
