package LoggingDemo;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingDemo {

    @Test(priority = 1)
    void testLogs(){

        given().when()
                .get("https://reqres.in/api/users?page=2").then()
                .log().body()
                .log().headers()
                .log().cookies();

    }
}
