package RestAssured.Bai8_PATCH_DELETE;

import RestAssured.Common.BaseTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testUpdateUser_PATCH extends BaseTest {

    @Test
    public void testUpdateUser() {
        loginUser(); // gọi lại hàm loginUser để chạy login lấy token
        PatchUserPOJO patchUserPOJO = new PatchUserPOJO();
        patchUserPOJO.setFirstname("Bốddi");
        patchUserPOJO.setLastname("Bốddi");
        patchUserPOJO.setEmail("bv@email.com");
        patchUserPOJO.setPhone("0123406789");
        patchUserPOJO.setUserStatus(1);
        Gson gson = new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + TOKEN) // sau BEARE phải cách ra 1 cách
                .body(gson.toJson(patchUserPOJO));
        Response response = request.when().patch("/user/333");
        response.prettyPrint();
//        response.then().statusCode(200);
    }
}
