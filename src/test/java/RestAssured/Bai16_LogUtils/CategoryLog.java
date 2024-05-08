package RestAssured.Bai16_LogUtils;

import RestAssured.Common.BaseTest;
import RestAssured.Listen.TestListener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.globals.ConfigsGlobal;
import org.example.globals.TokenGlobal;
import org.example.untils.LogUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
@Listeners(TestListener.class)
public class CategoryLog extends BaseTest {
    int CATEGORY_ID;
    @Test
    public void testAddNewCategory(){
        LogUtils.info("Create Category");
        loginUser();
        String dataFile = "src/test/resources/testdata/CreateCategory.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization ", "Bearer " + TokenGlobal.TOKEN)
                .body(new File(dataFile));
        Response response = request.post("/category");
//        String id = response.getBody().path("response.id");
        LogUtils.info(response.prettyPrint());
        response.prettyPrint();
        CATEGORY_ID = Integer.parseInt(response.path("response.id").toString());
        LogUtils.info(CATEGORY_ID);
        response.then().statusCode(200);
    }
}
