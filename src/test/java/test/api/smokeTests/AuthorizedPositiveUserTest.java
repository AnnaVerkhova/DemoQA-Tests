package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.LoginRequest;
import org.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;
import test.security.PasswordManager;


public class AuthorizedPositiveUserTest extends BaseApiTest {
    @Test
    public void authorizedPositiveTest() {
        LoginRequest request = LoginRequest.builder()
                .userName(ConfigManager.getConfig().username())
                .password(PasswordManager.getDecryptedPassword(ConfigManager.getConfig()))
                .build();

        Response response = ApiSender.authorized(request);
        Assert.assertEquals(response.statusCode(), 200,"Expected status code " +
                "200 for successful authorization, but received:");
        Boolean isAuthorized = response.as(Boolean.class);
        Assert.assertTrue(isAuthorized,"The user should have been successfully " +
                "logged in, but the API returned false.");
    }
}