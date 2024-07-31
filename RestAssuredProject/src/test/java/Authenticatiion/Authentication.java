package Authenticatiion;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Authentication {

    @Test(priority = 1)
    void testBasicAuthentication(){
        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth").then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 2)
    void testDigestAuthentication(){
        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth").then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 3)
    void testPremitiveAuthentication(){
        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth").then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }
}
