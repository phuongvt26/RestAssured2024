package RestAssured.Common;

import RestAssured.Bai6_POJO_JSON.LoginPOJO;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseTest {
        //Khai báo biến toàn tục TOKEN để lưu trữ từ hàm Login
        public String TOKEN = "";

        @Test
        public void loginUser() {
            LoginPOJO loginPOJO = new LoginPOJO("anhtester", "Demo@123");
            Gson gson = new Gson();

            RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .body(gson.toJson(loginPOJO));

        Response response = request.when().post("/login");
        response.prettyPrint();
        response.then().statusCode(200);

        //Lưu giá trị token vào biến TOKEN nhé
        TOKEN = response.getBody().path("token");
        System.out.println(TOKEN);
    }
}
