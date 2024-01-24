package RestAssured.Bai6_POJO_JSON;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoBooking {
    @Test
    public void testCreatedBooking(){
        // Khoi tao 2 doi tuong class booking date, booking body
        BookingBodyPOJO bookingBody = new BookingBodyPOJO();
        BookingDatePOJO bookingDate = new BookingDatePOJO();
        bookingBody.setFirstname("Phuong");
        bookingBody.setLastname("Vo");
        bookingBody.setTotalprice(200);
        bookingBody.setDepositpaid(false);
        bookingBody.setAdditionalneeds("Automation");
        bookingDate.setCheckin("2023-12-15");
        bookingDate.setCheckout("2023-12-30");
        //Set giá trị cho 2 fields con từ class POJO phụ

        bookingBody.setBookingdates(bookingDate);
        RequestSpecification request = given();
        Gson gson = new Gson();
        request.baseUri("https://restful-booker.herokuapp.com")
                .accept("application/json")
                .contentType("application/json")
                .body(gson.toJson(bookingBody));
        Response response = request.when().post("/booking");

        response.prettyPrint();
        request.then().statusCode(200);



    }
}
