package test.api;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.config.ConfigManager;
import org.testng.annotations.BeforeClass;
import test.ui.BaseTest;


public class BaseApiTest extends BaseTestForApi {

    @BeforeClass
    public void apiSetup() {
        RestAssured.baseURI = ConfigManager.getConfig().baseUrl();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
