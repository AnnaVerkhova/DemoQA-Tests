package test.api;

import org.aeonbits.owner.ConfigFactory;
import org.config.TestConfig;

public class BaseTestForApi {
    protected static TestConfig config =
            ConfigFactory.create(TestConfig.class);
}
