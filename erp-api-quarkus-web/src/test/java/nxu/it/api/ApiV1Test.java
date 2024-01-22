package nxu.it.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ApiV1Test {
   // @Test
    void testAuthor(){
        given().when()
                .get("/api/v1/author")
                .then()
                .statusCode(200);
    }
}
