package RestAssured.Bai3_SendRequest_GET;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class DemoAddHeader {
    @Test
    public void testAddHeader(){
        //Khai baos doi tuong request
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api");
        request.basePath("/users");
        //add header theo yeu cau voi cu phap (key,value)
        request.header("accept","application/json");
        //request.header("", "");
        //Khai báo đối tượng response để nhận giá trị trả về từ hàm when() làm gì đó
        Response response= request.when().get();
        // in ra gia tri response nhan ve
        response.prettyPrint();  //prettyPrint() là in với nội dung body đã format đẹp mắt
        response.then().statusCode(200);

    }
}
