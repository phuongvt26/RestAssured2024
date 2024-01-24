package RestAssured.Bai7_Authentication_PUTmethod;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FormAuth {
    @Test
    public void testFormAuth(){
        given()
                .auth()
                .form("postman","password")
                .get("https://the-internet.herokuapp.com/basic_auth");
    }

}
