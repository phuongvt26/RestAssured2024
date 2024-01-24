package RestAssured.Bai6_POJO_JSON;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoLoginPOJO {
    @Test
    public void testLoginUser() {
        //Khởi tạo giá trị cho các fields thông qua hàm xây dựng có tham số
        LoginPOJO loginPOJO = new LoginPOJO("anhtester", "Demo@123");
        //Dung thu vien gson chuyen class pojo ve dang json
        Gson gson = new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json").body(gson.toJson(loginPOJO)); // Tu chuyen POJO class sang json data

        Response response= request.when().post("/login");
        response.prettyPrint();
        request.then().statusCode(200);
        String token = response.getBody().path("token");
        System.out.println(token);

    }

}
