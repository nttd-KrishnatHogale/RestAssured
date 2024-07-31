package JsonSchema;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;


import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.then;;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation {
    @Test
    void jsonSchemaValidatior(){
        given().when()
                .get("http://localhost:3000/stores").then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemna.json"));

    }
}
