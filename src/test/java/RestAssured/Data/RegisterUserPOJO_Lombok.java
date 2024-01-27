package RestAssured.Data;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Builder
//https://anhtester.com/lesson/rest-assured-su-dung-lombok-de-xay-dung-pojo-class
public class RegisterUserPOJO_Lombok {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
