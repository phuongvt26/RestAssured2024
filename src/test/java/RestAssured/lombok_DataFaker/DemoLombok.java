package RestAssured.lombok_DataFaker;

import RestAssured.Common.BaseTest;
import RestAssured.model.RegisterUserPOJO_Lombok;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.datafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;

//https://anhtester.com/lesson/rest-assured-su-dung-lombok-de-xay-dung-pojo-class
public class DemoLombok extends BaseTest {
    @Test
    public void testLombok() {
        UserPOJOLombok userPOJOLombok = new UserPOJOLombok(
                "phuongvt",
                "vo",
                "thi",
                "phuong1@gmail.com",
                "123456",
                "0358153666",
                1
        );
        System.out.println(userPOJOLombok.getUsername());
    }
    @Test
    public void testDataFaker() {
        Faker faker = new Faker(new Locale("vi")); // vi:S dùng Tieng viet
        String computer = faker.computer().windows();
        String name = faker.name().fullName();
        String fullAddress = faker.address().fullAddress();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        System.out.println(computer);
        System.out.println(name);
        System.out.println(fullAddress);
        System.out.println(email);
        System.out.println(password);
    }
    @Test
public void testUpdateUserLombok(){
        loginUser();
        Faker faker = new Faker(new Locale("vi"));
        String phoneNumber = faker.phoneNumber().cellPhone();
        phoneNumber = phoneNumber.replace(" ", "");
        //Chuẩn bị data cho edit user
        RegisterUserPOJO_Lombok registerUserPOJO_lombok = new RegisterUserPOJO_Lombok();
        registerUserPOJO_lombok.setFirstName(faker.name().firstName());
        registerUserPOJO_lombok.setLastName(faker.name().lastName());
        registerUserPOJO_lombok.setEmail(faker.internet().emailAddress());
        registerUserPOJO_lombok.setPhone(phoneNumber);
        registerUserPOJO_lombok.setUserStatus(0);

        Gson gson= new Gson();
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + TOKEN) // sau BEARE phải cách ra 1 cách
                .body(gson.toJson(registerUserPOJO_lombok));
        Response response = request.when().patch("/user/333");
        response.prettyPrint();
        response.then().statusCode(200);
//        String message = response.getBody().path("message");
//        Assert.assertEquals(message, "Success", "The message not match.");

}
public void testCreatedUserLombok(){
        Faker faker = new Faker();

}

}
