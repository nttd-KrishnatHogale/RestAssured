package waystoCreateRequestBody;

import org.testng.annotations.Test;

import java.util.HashMap;

//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;

/*
Different ways to create POST request body
1) Post request body using Hashmap
2) Post request body creation using using Org.JSON
3) Post request body creation using POJO class
4) Post request using external json file data
*/
public class differnetWayToCreateRequestBody {
    @Test(priority = 1)
    void testPostusingHashMap() {
        HashMap data = new HashMap();
        data.put("name", "krh");
        data.put("location", "MH");

        data.put("phone", "12321234");

        String CourseArr[] = {"C", "C++"};
        data.put("courses", CourseArr);

        given().contentType("application/json")
                .body(data)
                .when().post("http://localhost:3001/students")
                .then().statusCode(201)
                .body("name", equalTo("krh"))
                .body("location", equalTo("MH"))
                .body("phone", equalTo("12321234"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C++"))
                .header("Content-Type", "application/json")
                .log().all();
    }

    @Test(priority = 2)
    void testDelete() {
        given()
                .when()
                .delete("http://localhost:3001/students/8197")
                .then()
                .statusCode(200);
    }
}
