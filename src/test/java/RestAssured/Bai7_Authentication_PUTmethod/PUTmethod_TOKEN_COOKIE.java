package RestAssured.Bai7_Authentication_PUTmethod;

import RestAssured.Bai6_POJO_JSON.LoginPOJO;
import RestAssured.Bai6_POJO_JSON.RegisterPOJO;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
// https://api.anhtester.com/swagger/index.html#/User%20Management/updateUser
public class PUTmethod_TOKEN_COOKIE  {
    String token = "";
    @Test
    public void loginUser(){
        //Khởi tạo giá trị cho các fields thông qua hàm xây dựng
        LoginPOJO login = new LoginPOJO("anhtester","Demo@123");
        //Dùng thư viện Gson để chuyển class POJO về dạng JSON
        Gson gson= new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .body(gson.toJson(login));
        Response response = request.when().post("/login");
        response.prettyPrint();
        response.then().statusCode(200);
        //Lưu giá trị token vào biến token nhé
        token = response.getBody().path("token");
        System.out.println(token);

    }
@Test
    public void testEditUser_NoAuth(){
        RegisterPOJO register = new RegisterPOJO();
        register.setUsername("myduyen5");
        register.setPassword("Demo@1273");
        register.setFirstName("Lê Thị");
        register.setLastName("Mỹ Duyên");
        register.setEmail("myduyen6@email.com");
        register.setPhone("0123456789");
        register.setUserStatus(1);

        Gson gson= new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization","Bearer "+token)
                .body(gson.toJson(register));
        Response response= request.when().put("/user/313");
        response.prettyPrint();
        response.then().statusCode(200);



    }
}
