package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

    @Test
    public void createUserTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String requestBody = "{\"id\": 1, \"username\": \"TestUser\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"johndoe@example.com\"}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("1"));
    }

    @Test
    public void deleteUserTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        given()
                .pathParam("username", "TestUser")
                .when()
                .delete("/user/{username}")
                .then()
                .statusCode(200);
    }

    // Тесты для остальных операций с пользователем аналогичны.
}
