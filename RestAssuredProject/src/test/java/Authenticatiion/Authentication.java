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
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth").then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }
    @Test
    void testBearerTokenAuthentication(){

        String beareeToken = "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";
        given()
                .headers("Authorization","Bearer "+beareeToken).when()
                .get("https://github.com/nttd-KrishnatHogale?tab=repositories").then()
                .statusCode(200).log().all();

    }

    @Test
    void testOAuth1Authentication(){
        given()
                .auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecrete")
                .when()
                .get("url")
                .then().statusCode(200).log().all();

    }

    @Test
    void testAuth2Authentication(){
        given()
                .auth().oauth2("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")
                .when()
                .get("https://github.com/nttd-KrishnatHogale?tab=repositories").then()
                .statusCode(200).log().all();
    }

    @Test
    void testAPIKAYAuthentication(){
        given()
                .queryParam("","").when()
                .get("url").then()
                .statusCode(200)
                .log().all();
    }
}
