package RestAssured.Bai5_PhuongThucPOST;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoPostMethod {
    // API: https://anhtester.com/lesson/rest-assured-su-dung-post-method-trong-rest-assured
    @Test
    public void testLoginUser(){
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "  \"username\": \"anhtester\",\n" +
                        "  \"password\": \"Demo@123\"\n" +
                        "}");
        // Thuc hien post de gui du lieu di

        Response response= request.when().post("/login");
        response.prettyPrint();
        response.then().statusCode(200);
        String token = response.getBody().path("token").toString();
        System.out.println(token);

    }

}
