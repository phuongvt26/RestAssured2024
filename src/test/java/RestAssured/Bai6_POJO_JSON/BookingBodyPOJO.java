package RestAssured.Bai6_POJO_JSON;

public class BookingBodyPOJO {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    //Kiểu dữ liệu là class BookingDates
    private BookingDatePOJO bookingdates;

    private String additionalneeds;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingdates(BookingDatePOJO bookingdates) {
        this.bookingdates = bookingdates;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
