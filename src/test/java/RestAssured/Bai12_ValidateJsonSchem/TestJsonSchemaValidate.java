package RestAssured.Bai12_ValidateJsonSchem;

import RestAssured.Common.BaseTest;
import io.restassured.response.Response;
import org.example.globals.ConfigsGlobal;
import java.io.InputStream;
import static io.restassured.RestAssured.given;
public class TestJsonSchemaValidate extends BaseTest {
    public void testJsonSchema_getBookById(){
       // ọc cái file json schema mà mình đã lưu vào thư mục "src/test/resources
        InputStream getBookIdSchema = getClass().getClassLoader().getResourceAsStream("GetBookAllSchema.json");
        // Perform the API request and get the response
        Response response = given()
                .baseUri(ConfigsGlobal.URI)
                .when()
                .get("/book/10")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();
        response.prettyPrint();
        // Validate the response against the JSON schema
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getBookIdSchema));


    }
}
