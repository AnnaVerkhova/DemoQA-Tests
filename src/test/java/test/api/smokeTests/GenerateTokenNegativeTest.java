package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.GenerateTokenResponse;
import org.api.data.account.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;

public class GenerateTokenNegativeTest extends BaseApiTest {
    @Test
    public void generateTokenNegativeTest() {
    LoginRequest request = LoginRequest.builder()
            .userName(config.username())
            .password(config.invalidPassword())
            .build();
        Response response = ApiSender.generateToken(request);

        Assert.assertEquals(response.statusCode(), 200,"Expected status code " +
                "200 for successful authorization, but received:");
        GenerateTokenResponse generateTokenResponse = response.as(GenerateTokenResponse.class);
        Assert.assertNull(generateTokenResponse.getToken(),"The token should not be generated if the " +
                "password is incorrect, but was received:");
        Assert.assertEquals(generateTokenResponse.getStatus(),"Failed","Expected 'Failed' " +
                "status with invalid data, but received:");
    }
}