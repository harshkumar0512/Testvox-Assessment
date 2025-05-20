import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReqresApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    @Order(1)
    void testGetUsersPage2() {
        Response response = given()
            .queryParam("page", 2)
            .when().get("/users")
            .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(greaterThan(0)))
                .extract().response();

        // Optionally print the list size
        int userCount = response.jsonPath().getList("data").size();
        System.out.println("Users on page 2: " + userCount);
    }

    @ParameterizedTest
    @CsvSource({
        "morpheus, leader",
        "neo, chosen one"
    })
    @Order(2)
    void testPostCreateUser(String name, String job) {
        String payload = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", name, job);

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo(name))
            .body("job", equalTo(job))
            .body("id", notNullValue())
            .body("createdAt", notNullValue());
    }

    @Test
    @Order(3)
    void testDeleteUser() {
        int userId = 2; // Demo user id
        given()
            .when()
            .delete("/users/" + userId)
            .then()
            .statusCode(204);
    }
}