package test.security;

import io.qameta.allure.Step;
import test.TestConfig;

public class PasswordManager {

    @Step("Get decrypted password from config")
    public static String getDecryptedPassword(TestConfig config) {

        return CipherUtil.decrypt(config.password());
    }
}
