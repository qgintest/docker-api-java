package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    // 1. GET - Retrieve a user
    @Test
    public void getUserTest() {

        given()
                .pathParam("userId", 2)
                .when()
                .get("/api/users/{userId}")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", notNullValue());
    }


    // 2. POST - Create a user
    @Test
    public void createUserTest() {

        String requestBody = """
            {
                "name": "John",
                "job": "SDET"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("John"))
                .body("job", equalTo("SDET"))
                .body("id", notNullValue());
    }


    // 3. PUT - Update a user
    @Test
    public void updateUserTest() {

        String requestBody = """
            {
                "name": "John",
                "job": "Principal SDET"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body(requestBody)
                .when()
                .put("/api/users/{userId}")
                .then()
                .statusCode(200)
                .body("name", equalTo("John"))
                .body("job", equalTo("Principal SDET"));
    }


    // 4. DELETE - Delete a user
    @Test
    public void deleteUserTest() {

        given()
                .pathParam("userId", 2)
                .when()
                .delete("/api/users/{userId}")
                .then()
                .statusCode(204);
    }
}
