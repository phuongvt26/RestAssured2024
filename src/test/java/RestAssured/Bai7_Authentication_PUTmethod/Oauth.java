package RestAssured.Bai7_Authentication_PUTmethod;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Oauth {
    @Test
    public void testOAuth1(){
        given().auth()
                .oauth("consumerKey","consumerSecret","acccessToken","tokenSecret")
                .get("your end point URL");

    }
    @Test
    public void testOAuth2(){
        given().auth()
                .oauth2("access token")
                .get("your end point URL");
    }
}
