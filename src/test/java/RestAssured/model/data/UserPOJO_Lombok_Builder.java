package RestAssured.model.data;

import RestAssured.model.RegisterUserPOJO_Lombok;
import net.datafaker.Faker;

import java.util.Locale;

public class UserPOJO_Lombok_Builder {
    public static RegisterUserPOJO_Lombok getUserData(){
        Faker faker = new Faker(new Locale("vi"));
        String phoneNumber = faker.phoneNumber().cellPhone();
        phoneNumber = phoneNumber.replace(" ", "");
        return RegisterUserPOJO_Lombok.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(phoneNumber)
                .userStatus(0)
                .build();

    }
}
