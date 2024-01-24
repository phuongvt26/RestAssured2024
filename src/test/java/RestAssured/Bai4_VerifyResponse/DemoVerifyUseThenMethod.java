package RestAssured.Bai4_VerifyResponse;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class DemoVerifyUseThenMethod {
    @Test
    public void testVerifyResponseUserThenMethod(){
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api").accept("application/json");
        int id= 1; // id của book
        Response response= request.when().get("/book/"+id);
        response.prettyPrint();
        // verify kq respone với hàm then()
        response.then().statusCode(200);
        response.then().contentType("application/json");
        //Đối với body thì cần điền cấu trúc theo xpath từ json
        //Hàm equalTo thuộc thư viện org.hamcrest.Matchers
        response.then().body(("response.name"),equalTo("Đất Rừng Phương Nam"));
        response.then().body(("response.price"),equalTo(12000));
        response.then().body(("reponse.image[0]"),containsString("public/images/1avh0VncWc"));

    }



}
