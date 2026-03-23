package org.config;

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

    @Key("urlDB")
    String urlDB();

    @Key("userDB")
    String userDB();

    @Key("passwordDB")
    String passwordDB();

    @Key("browser")
    String browser();

    @Key("headless")
    boolean headless();

    @Key("implicitTimeout")
    int implicitTimeout();

    @Key("explicitTimeout")
    int explicitTimeout();

    @Key("urlLogin")
    String urlLogin();

    @Key("urlProfile")
    String urlProfile();

    @Key("urlBooks")
    String urlBooks();
}