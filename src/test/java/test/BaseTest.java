package test;

import org.aeonbits.owner.ConfigFactory;

public class BaseTest {
    protected static TestConfig config =
            ConfigFactory.create(TestConfig.class);
}
