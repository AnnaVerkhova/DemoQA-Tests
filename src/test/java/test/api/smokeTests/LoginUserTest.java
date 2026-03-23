package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.LoginRequest;
import org.api.data.account.LoginResponse;
import org.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;
import test.security.PasswordManager;

public class LoginUserTest extends BaseApiTest {
    @Test
    public void loginTest(){
        LoginRequest request = LoginRequest.builder()
                .userName(ConfigManager.getConfig().username())
                .password(PasswordManager.getDecryptedPassword(ConfigManager.getConfig()))
                .build();
        Response response = ApiSender.login(request);
        Assert.assertEquals(response.statusCode(),200,"Expected status code 200" +
                " for successful login, but received: ");
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(loginResponse.getUsername(),ConfigManager.getConfig().username(),"The username in the" +
                " response does not match the expected one. Expected: ");
        Assert.assertNotNull(loginResponse.getUserId(),"UserId must not be null after successful login.");
    }
}