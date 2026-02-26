package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.GenerateTokenResponse;
import org.api.data.account.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;

public class GenerateTokenPositiveTest extends BaseApiTest {
    @Test
    public void generateTokenPositiveTest() {
        LoginRequest request = LoginRequest.builder()
                .userName(config.username())
                .password(config.password())
                .build();
        Response response = ApiSender.generateToken(request);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        GenerateTokenResponse generateTokenResponse = response.as(GenerateTokenResponse.class);
        Assert.assertNotNull(generateTokenResponse.getToken());
        Assert.assertFalse(generateTokenResponse.getToken().isEmpty());
        Assert.assertEquals(generateTokenResponse.getStatus(), "Success");
        Assert.assertTrue(generateTokenResponse.getResult().contains("authorized"));
    }
}
