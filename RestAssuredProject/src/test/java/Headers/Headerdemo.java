package Headers;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Headerdemo {
//    @Test
//    void testHeader(){
//        given().when()
//                .get("https://www.google.com/").then()
////                .cookie("ACE","AVYB7cr8Zgf0V3xgvkySCsaYtaUYd5synPvFgQ4EmZxMVaE3NBlE1BD4fI  ")
//                .header("Content-Type","text/html; charset=ISO-8859-1")
//                .header("Content-Encoding","gzip")
//                .header("Server","gws");
////                .log().all();
//    }

    @Test
    void getHeader(){
        Response res = given()
                .when()
                .get("https://www.google.com/");

        //get single header info
//        String headervalue = res.getHeader("Content-Type");
//        System.out.println("The value of content type is ===>"+headervalue);

        //get all headers info
        Headers myheaders = res.getHeaders();
        for (Header hd:myheaders){
            System.out.println(hd.getName()+"   "+hd.getValue());
        }
    }
}
