package org.config;


import org.aeonbits.owner.ConfigFactory;

public class ConfigManager {
    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class);

    public static TestConfig getConfig() {
        return config;
    }
}
