package RestAssured.Bai6_POJO_JSON;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoRegisterPOJO {
    @Test
    public void testRegisterUser() {
        RegisterPOJO registerPOJO = new RegisterPOJO();
        registerPOJO.setUsername("aaadf");
        registerPOJO.setPassword("Deđmo@123");
        registerPOJO.setFirstName("Ha dThị");
        registerPOJO.setLastName("Mỹd a");
        registerPOJO.setEmail("hoaa@email.com");
        registerPOJO.setPhone("0223411189");
        registerPOJO.setUserStatus(1);
        Gson gson = new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .body(gson.toJson(registerPOJO));

        Response response = request.when().post("/register");
        response.prettyPrint();

        response.then().statusCode(200);
        String message = response.getBody().path("message");
        Assert.assertEquals(message, "Success", "The message not match.");

    }

}
