package RestAssured.Bai6_POJO_JSON;

public class BookingDatePOJO {
    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
