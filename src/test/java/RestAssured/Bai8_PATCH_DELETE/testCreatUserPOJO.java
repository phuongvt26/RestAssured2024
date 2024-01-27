package RestAssured.Bai8_PATCH_DELETE;

import RestAssured.Common.BaseTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testCreatUserPOJO extends BaseTest {
    @Test
    public void testCreateUser(){
        loginUser();
        CreateUserPOJO createUserPOJO = new CreateUserPOJO();
        createUserPOJO.setUsername("phuongvt");
        createUserPOJO.setFirstName("vo");
        createUserPOJO.setLastName("thi");
        createUserPOJO.setPassword("deemo@123");
        createUserPOJO.setPhone("0658156666");
        createUserPOJO.setEmail("vophuuong@gmail.com");
        createUserPOJO.setUserStatus(1);

        Gson gson= new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .header("Authorization","Bearer "+TOKEN)
                .contentType("application/json").body(gson.toJson(createUserPOJO)); // Tu chuyen POJO class sang json data

        Response response= request.when().post("/user");
        response.prettyPrint();
        request.then().statusCode(200);
    }
}
