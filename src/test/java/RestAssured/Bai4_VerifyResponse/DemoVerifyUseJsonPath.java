package RestAssured.Bai4_VerifyResponse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoVerifyUseJsonPath {
    @Test
    public void testVerifyResponseUseAssertTestNG(){
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api").accept("application/json");
        int id=1;
        Response response = request.when().get("/book/" + id);
        response.prettyPrint();
        //Verify kq từ response với Assert trong TestNG
        // Dùng class Assert . gọi 2 hàm chính là assertEquals và assertTrue
        Assert.assertEquals(response.getStatusCode(),200, " Status fail");
        Assert.assertEquals(response.getContentType(),"application/json", "Content Type fail");
        // muốn lấy giá trị từng key trong json body sử dụng jsonpath
        JsonPath jsonPath= response.jsonPath(); //Lưu hết body vào đối tượng jsonPath
        String name = jsonPath.get("response.name");
        System.out.println(name);
        // dùng assert trong test NG để verify
        Assert.assertEquals(name.contains("Đất Rừng Phương Nam"), true, "Name không tồn tại.");
        Assert.assertEquals(jsonPath.get("response.price").toString(),"12000","price k dung");
        String path_image2 = jsonPath.get("response.image[1].path");
        System.out.println(path_image2);
        Assert.assertEquals(jsonPath.get(path_image2),"public/images/TwSX1W1RgW26ppX3fhDtxVcLV7tsJAooDtxJWBP7.png","path fail");
        Assert.assertTrue(path_image2.contains("public/images/TwSX1W1"),"path image 2 fail");




    }

}
