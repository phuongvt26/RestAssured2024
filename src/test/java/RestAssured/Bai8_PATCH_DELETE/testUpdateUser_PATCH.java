package RestAssured.Bai8_PATCH_DELETE;

import RestAssured.Bai6_POJO_JSON.LoginPOJO;
import RestAssured.Bai6_POJO_JSON.RegisterPOJO;
import RestAssured.Common.BaseTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testUpdateUser_PATCH extends BaseTest {

    @Test
    public void testUpdateUser() {
        loginUser(); // gọi lại hàm loginUser để chạy login lấy token
        PatchUserPOJO patchUserPOJO = new PatchUserPOJO();
        patchUserPOJO.setFirstname("Bối");
        patchUserPOJO.setLastname("Bối");
        patchUserPOJO.setEmail("boiboi1@email.com");
        patchUserPOJO.setPhone("0123456789");
        patchUserPOJO.setUserStatus(1);
        Gson gson = new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + TOKEN) // sau BEARE phải cách ra 1 cách
                .body(gson.toJson(patchUserPOJO));
        Response response = request.when().patch("/user/313");
        response.prettyPrint();
//        response.then().statusCode(200);
    }
}
