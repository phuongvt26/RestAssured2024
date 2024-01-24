package RestAssured.Bai7_Authentication_PUTmethod;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuth {
    @Test
    public void getData() {
        RequestSpecification request = given();
        Response response = request.get("https://postman-echo.com/basic-auth");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        response.then().statusCode(200);

    }

    @Test
    public void testBasicAuth() {
        RequestSpecification request = given().auth().basic("postman", "password");
        Response response = request.get("https://postman-echo.com/basic-auth");
        System.out.println(response.getStatusCode());
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testPreemptiveBasicAuth() {
        RequestSpecification request = given().auth().preemptive().basic("postman", "password");
        Response response = request.get("https://postman-echo.com/basic-auth");
        System.out.println(response.getStatusCode());
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());
    }

}
