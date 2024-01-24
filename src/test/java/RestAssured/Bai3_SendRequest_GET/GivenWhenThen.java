package RestAssured.Bai3_SendRequest_GET;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GivenWhenThen {
    @Test
    public void testGivenWhenThen() {
        given().baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .when().get("users")
                .then().statusCode(200).contentType(ContentType.JSON);
    }
}
