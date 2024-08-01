package APIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {
    @Test
    void test_updateUser(ITestContext context){
//        int id = (Integer) context.getAttribute("user_id");
        int id = (Integer) context.getSuite().getAttribute("user_id");

        Faker faker=new Faker();
        JSONObject data=new JSONObject();

        data.put("name",faker.name().fullName());
        data.put("gender","female");
        data.put("email",faker.internet().safeEmailAddress());
        data.put("status","active");

        String bearerToken = "2f6d6adfe073a6c6e97a8d01b79eaf355d7c757c269e07e4898b688fe7979703";

        given()
                .headers("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .pathParam("id",id)
                .body(data.toString())
                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
