package com.srs.common.config;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;


public abstract class BaseServiceConfigLoader {
    protected final EntityManager entityManager;

    public BaseServiceConfigLoader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Map<String, String> load(String configTable) {
        var configMap = new HashMap<String, String>();

        var query = String.format("select key, value from %s", configTable);

        var result = entityManager.createNativeQuery(query).getResultList();

        for (var config : result) {
            var configPair = (Object[]) config;
            configMap.put((String) configPair[0], (String) configPair[1]);
        }

        return configMap;
    }
}
