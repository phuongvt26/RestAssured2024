package RestAssured.Bai11_ReadJsonFile;

import RestAssured.Common.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.globals.ConfigsGlobal;
import org.example.globals.TokenGlobal;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DemoReadJsonFile extends BaseTest {
    @Test
    public void testLoginUser() {
        String filePath = "src/test/resources/testdata/Login.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .accept("application/json")
                .contentType("application/json")
                .body(new File(filePath));

        Response response = request.when().post("/login");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void testRegisterUser() {
        String filePath = "src/test/resources/testdata/Register.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .contentType("application/json")
                .accept("application/json")
                .body(new File(filePath));
        Response response = request.when().post("/register");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void testCreatedUser() {
        loginUser();
        String filePath = "src/test/resources/testdata/CreateUser.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization", "Bearer "+ TokenGlobal.TOKEN)
                .body(new File(filePath));
        Response response= request.when().post("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }




}
