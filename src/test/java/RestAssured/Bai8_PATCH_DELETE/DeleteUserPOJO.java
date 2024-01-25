package RestAssured.Bai8_PATCH_DELETE;

import RestAssured.Bai6_POJO_JSON.LoginPOJO;
import RestAssured.Common.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

// https://api.anhtester.com/swagger/index.html#/User%20Management/deleteUser
public class DeleteUserPOJO extends BaseTest {
    @Test
    public void testDeleteUser() {
        loginUser();
        String username = "phuongvt";
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .contentType("application/json")
                .accept("application/json")
                .queryParam("username", username)
                .header("Authorization", "Bearer " + TOKEN);

        Response response = request.when().delete("/user");
        response.then().statusCode(200);
        response.prettyPrint();
        String message = response.getBody().path("message");
        System.out.println(message);


    }
}
