package APIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class CreateUser {
@Test
    void testCreateUser(ITestContext context){
        Faker faker=new Faker();
        JSONObject data=new JSONObject();

        data.put("name",faker.name().fullName());
        data.put("gender","Male");
        data.put("email",faker.internet().safeEmailAddress());
        data.put("status","inactive");

        String bearerToken = "2f6d6adfe073a6c6e97a8d01b79eaf355d7c757c269e07e4898b688fe7979703";

        Integer id =given()
                .headers("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");
    System.out.println(id);

//    context.setAttribute("user_id",id);
context.getSuite().setAttribute("user_id",id);

    }
}
