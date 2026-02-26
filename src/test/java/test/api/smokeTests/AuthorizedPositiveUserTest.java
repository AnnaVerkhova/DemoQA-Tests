package test.api.smokeTests;

import io.restassured.response.Response;
import org.api.data.account.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;


public class AuthorizedPositiveUserTest extends BaseApiTest {
    @Test
    public void authorizedPositiveTest() {
        LoginRequest request = LoginRequest.builder()
                .userName(config.username())
                .password(config.password())
                .build();

        Response response = ApiSender.authorized(request);
        Assert.assertEquals(response.statusCode(), 200);
        Boolean isAuthorized = response.as(Boolean.class);
        Assert.assertTrue(isAuthorized);
        response.prettyPrint();
    }
}
