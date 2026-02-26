package test.api;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import test.BaseTest;

public class BaseApiTest extends BaseTest {

    @BeforeClass
    public void apiSetup() {
        RestAssured.baseURI = config.baseUrl();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
