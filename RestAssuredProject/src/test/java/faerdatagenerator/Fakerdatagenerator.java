package faerdatagenerator;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Fakerdatagenerator {
@Test
    void testGenerateDummydata(){
        Faker faker=new Faker();
        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String username= faker.name().username();
        String password = faker.internet().password();

        String phoneno = faker.phoneNumber().cellPhone();

        String email = faker.internet().safeEmailAddress();

        System.out.println(fullName);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(username);
        System.out.println(password);
        System.out.println(phoneno);
        System.out.println(email);

    }
}
