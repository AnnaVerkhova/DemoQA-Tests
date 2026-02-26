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
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        GenerateTokenResponse generateTokenResponse = response.as(GenerateTokenResponse.class);
        Assert.assertNull(generateTokenResponse.getToken());
        Assert.assertEquals(generateTokenResponse.getStatus(),"Failed");

        System.out.println("Token is " + generateTokenResponse.getToken());
        System.out.println("Status is " +generateTokenResponse.getStatus());
    }
}
