package test;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})

public interface TestConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("invalidPassword")
    String invalidPassword();
}
