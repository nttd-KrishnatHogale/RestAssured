package PathAndQueryParamss;

import org.testng.annotations.Test;

import java.util.HashMap;

//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;

public class PathAndQueryParams {
    //https:reqres.in/api/users?page=2&id=5

    @Test
    void TestQueryAndPathParams(){
        given()
                .pathParam("mypath","users")//path params
                    .queryParam("page",2)//query params
                    .queryParam("id",5)
                    .when()
                    .get("https://reqres.in/api/{mypath}").then()
                    .statusCode(200)
                    .log().all();
        }
}
