package RestAssured.Bai8_PATCH_DELETE;

public class PatchUserPOJO {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private int userStatus;

    public PatchUserPOJO(String firstname, String lastname, String email, String phone, int userStatus) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public PatchUserPOJO() {

    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
