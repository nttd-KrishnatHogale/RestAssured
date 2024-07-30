package XMLParsing;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class ParsingXMLResponse {

    @Test
    void testXMLResponse(){
        given().when()
                .get("https://petstore.swagger.io/v2/pet/2").then()
                .statusCode(200)
//                .header("Content-Type","accept: application/xml");
                .body("Pet.category.id",equalTo(2));
    }
}
