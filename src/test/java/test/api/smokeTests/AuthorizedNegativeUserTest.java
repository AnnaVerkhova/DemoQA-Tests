package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;

public class AuthorizedNegativeUserTest extends BaseApiTest {
    @Test
    public void AuthorizedNegativeTest() {
        LoginRequest request = LoginRequest.builder()
                .userName(config.username())
                .password(config.invalidPassword())
                .build();

        Response response = ApiSender.authorized(request);
        Assert.assertEquals(
                response.statusCode(),404,
                "In case of invalid authorization data, the status code 404 " +
                        "was expected, but the following was received: " + response.statusCode());
    }
}