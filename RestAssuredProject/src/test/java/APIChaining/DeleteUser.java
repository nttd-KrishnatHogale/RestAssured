package APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {
@Test
    void test_deleteUser(ITestContext context){
//    int id = (Integer) context.getAttribute("user_id");
    int id = (Integer) context.getSuite().getAttribute("user_id");

        String bearerToken = "2f6d6adfe073a6c6e97a8d01b79eaf355d7c757c269e07e4898b688fe7979703";
        given()
                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(204)
                .log().all();

    }
}
