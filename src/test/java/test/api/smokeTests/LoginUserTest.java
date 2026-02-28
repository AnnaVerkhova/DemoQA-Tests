package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.LoginRequest;
import org.api.data.account.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;
import test.security.PasswordManager;

public class LoginUserTest extends BaseApiTest {
    @Test
    public void loginTest(){
        LoginRequest request = LoginRequest.builder()
                .userName(config.username())
                .password(PasswordManager.getDecryptedPassword(config))
                .build();
        Response response = ApiSender.login(request);
        Assert.assertEquals(response.statusCode(),200);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(loginResponse.getUsername(),config.username());
        Assert.assertNotNull(loginResponse.getUserId());
        response.prettyPrint();
    }
}
