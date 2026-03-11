package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.GenerateTokenResponse;
import org.api.data.account.LoginRequest;
import org.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;
import test.security.PasswordManager;

public class GenerateTokenPositiveTest extends BaseApiTest {
    @Test
    public void generateTokenPositiveTest() {
        LoginRequest request = LoginRequest.builder()
                .userName(ConfigManager.getConfig().username())
                .password(PasswordManager.getDecryptedPassword(ConfigManager.getConfig()))
                .build();
        Response response = ApiSender.generateToken(request);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200,"Expected status code 200" +
                " for successful token generation, but received: ");
        GenerateTokenResponse generateTokenResponse = response.as(GenerateTokenResponse.class);
        Assert.assertNotNull(generateTokenResponse.getToken(),"The token must not be null upon" +
                " successful authorization.");
        Assert.assertFalse(generateTokenResponse.getToken().isEmpty(),"The token must not be empty" +
                " upon successful authorization.");
        Assert.assertEquals(generateTokenResponse.getStatus(), "Success","Expected status 'Success'," +
                " but received:");
        Assert.assertTrue(generateTokenResponse.getResult().contains("authorized"),"The result field " +
                "should contain 'authorized', but received:");
    }
}