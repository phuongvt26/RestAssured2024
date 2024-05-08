package RestAssured.Common;

import RestAssured.Bai6_POJO_JSON.LoginPOJO;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.globals.ConfigsGlobal;
import org.example.globals.TokenGlobal;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseTest {
        //Khai báo biến toàn tục TOKEN để lưu trữ từ hàm Login
        public String TOKEN = "";

        @Test
        public void loginUser() {
            LoginPOJO loginPOJO = new LoginPOJO(ConfigsGlobal.USERNAME, ConfigsGlobal.PASSWORD);
            Gson gson = new Gson();
            RequestSpecification request = given();
            request.baseUri(ConfigsGlobal.URI)
                    .accept("application/json")
                    .contentType("application/json")
                    .body(gson.toJson(loginPOJO));
            Response response = request.when().post("/login");
//            response.then().statusCode(200);
            TokenGlobal.TOKEN = response.getBody().path("token");
            System.out.println("Token Global: " + TokenGlobal.TOKEN);
    }
}
