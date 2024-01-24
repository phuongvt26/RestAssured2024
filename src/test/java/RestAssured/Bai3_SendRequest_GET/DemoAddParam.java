package RestAssured.Bai3_SendRequest_GET;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class DemoAddParam {
    @Test
    public void testGetByUserName(){
        //Khai báo đối tượng request để thiết lập điều kiện đầu vào
        //Dùng given() chỉ thị sự thiết lập sẵn điều kiện
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api");
        request.basePath("/user");
        request.accept("application/json");
        // Khai báo tham số đầu vào với hàm query param
        request.queryParam("username","anhtester");
        // request.pathParam("", "");
        // request.formParam("", "");
        //Khai báo đối tượng response để nhận giá trị trả về từ hàm when() làm gì đó
        //Cụ thể thì chúng ta dùng phương thức GET với hàm get() một endpoint
        Response response = request.when().get();
        // in ra giá trị response nhận về
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().statusLine("HTTP/1.1 200 OK");
        response.then().contentType(ContentType.JSON);
        response.then().body("response.username", equalTo("anhtester2"));
        response.then().body("response.email",containsString("an2"));


    }
    @Test
    public void tsstGetByUserFirstName(){
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api").basePath("/user").accept("application/json");
        request.queryParam("username","phuongvt");
        request.queryParam("firstName","phuong");
        request.queryParam("lastName","vo");
        request.queryParam("password","123456");
        request.queryParam("phone","0912345678");
        request.queryParam("userStatus",1);
        Response response= request.when().post();
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("response.username",equalTo("phuongvt"));

    }
}
