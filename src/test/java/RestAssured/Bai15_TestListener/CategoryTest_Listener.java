package RestAssured.Bai15_TestListener;

import RestAssured.Common.BaseTest;
import RestAssured.Listen.TestListener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.globals.ConfigsGlobal;
import org.example.globals.TokenGlobal;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
@Listeners(TestListener.class)
public class CategoryTest_Listener extends BaseTest {
    @Test
    public void testAddNewCategory(){
        loginUser();
        String dataFile= "src/test/resources/testdata/CreateCategory.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGlobal.TOKEN)
                .body(new File(dataFile));
        Response response = request.post("/category");
        int CategoryID =response.getBody().path("response.id");
        System.out.println(CategoryID);
    }
    public int getCategory(){
        loginUser();
        String dataFile= "src/test/resources/testdata/CreateCategory.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGlobal.TOKEN)
                .body(new File(dataFile));
        Response response = request.post("/category");
        response.prettyPrint();
        int CategoryID =response.getBody().path("response.id");
        System.out.println(CategoryID);
        return CategoryID;
    }
    @Test
    public void TestgetCategory(){
        loginUser();
        String dataFile= "src/test/resources/testdata/CreateCategory.json";
        RequestSpecification request = given();
        request.baseUri(ConfigsGlobal.URI)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGlobal.TOKEN)
                .body(new File(dataFile));
        Response response = request.get("/category/" +getCategory());
        response.prettyPrint();
    }
}
