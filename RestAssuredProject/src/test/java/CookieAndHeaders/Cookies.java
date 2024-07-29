package CookieAndHeaders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class Cookies {

//@Test
//    void testCookie(){
//        given().when()
//                .get("https://www.google.com/").then()
//                .cookie("ACE","AVYB7cr8Zgf0V3xgvkySCsaYtaUYd5synPvFgQ4EmZxMVaE3NBlE1BD4fI  ")
//                .log().all();
//    }

    @Test(priority = 2)
    void getCookie(){
       Response res = given().when()
                .get("https://www.google.com/");
//       String cookie_value = res.getCookie("AEC");
//        System.out.println("Value of cookie is ===> "+cookie_value);

        Map<String,String> cookie_valus = res.getCookies();
//        System.out.println(cookie_valus.keySet());
        for(String k:cookie_valus.keySet()){
           String cookie_value= res.getCookie(k);
            System.out.println(k+"    "+cookie_value);
        }

    }

}
