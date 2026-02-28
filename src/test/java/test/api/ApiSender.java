package test.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.api.url.Endpoints;

import static io.restassured.RestAssured.given;

public class ApiSender {
    @Step("Create LoginRequest")
    public static Response login(Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(Endpoints.LOGIN)
                .then()
                .extract()
                .response();
    }
    @Step("User authorization request")
    public static Response authorized(Object body){
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(Endpoints.AUTHORIZED)
                .then()
                .extract()
                .response();
    }
    @Step("Token generation request")
    public static Response generateToken(Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(Endpoints.GENERATE_TOKEN)
                .then()
                .extract()
                .response();
    }
    @Step("Get a list of books")
    public static Response getBooks() {
        return given()
                .when()
                .get(Endpoints.BOOKS)
                .then()
                .extract()
                .response();
    }
    @Step("Get user information")
    public static Response getUser(String username, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .pathParam("username", username)
                .when()
                .get(Endpoints.USER_BY_USERNAME);
    }
}
