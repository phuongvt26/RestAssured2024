package RestAssured.Bai7_Authentication_PUTmethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DigestAuth {
    @Test
    public void testDigestAuth(){
        RequestSpecification request = RestAssured.given().auth().digest("postman","password");
        Response response = request.get("https://postman-echo.com/basic-auth");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

}
