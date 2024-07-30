package ParsingJSONResponse;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;

//import static com.google.common.base.Predicates.equalTo;
import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class ParsinJSONResponseData {

    @Test(priority = 1)
    void testJsonResponse(){
//        approach 1
//    given()
//            .contentType("ContentType.JSONS").when()
//            .get("http://localhost:3001/book" ).then()
//            .statusCode(200)
//            .header("Content-Type","application/json")
//            .body("[3].title",equalTo("The Lord of the Rings"));


//        Approach 2
//        Response res =
//                given()
//                .contentType("ContentType.JSON")
//                        .when()
//                .get("http://localhost:3001/book");
//                Assert.assertEquals(res.getStatusCode(),200);
//                Assert.assertEquals(res.header("Content- Type"),"application/json");
//
//                String bookname =res.jsonPath().get("[3].title").toString();
//                Assert.assertEquals(bookname,"The Lord of the Rings");
//    Approach 3
        Response res =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("http://localhost:3001/stores");
//        Assert.assertEquals(res.getStatusCode(),200);
//        Assert.assertEquals(res.header("Content- Type"),"application/json");
//
//        String bookname =res.jsonPath().get("[3].title").toString();
//        Assert.assertEquals(bookname,"The Lord of the Rings");

//        jsonobject class
        JSONObject jo=new JSONObject(res.asString()); //converstin response to json object
//        System.out.println(jo);

//        for (int i=0;i<jo.getJSONArray("book").length();i++){
//            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
//            System.out.println(bookTitle);
//        }
            boolean status = false;

            //search for the book in json
        for (int i=0;i<jo.getJSONArray("book").length();i++){
            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
//            System.out.println(bookTitle);
            if(bookTitle.equals("The Lord of the Rings")){
                status=true;
                break;
            }
        }
        Assert.assertEquals(status,true);

        //validate total price of books
            double totalPrice=0;
        for(int i = 0; i<jo.getJSONArray("book").length();i++){
            String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice=totalPrice+Double.parseDouble(price);
        }
        System.out.println("total price of books is "+totalPrice);
        Assert.assertEquals(totalPrice,526.0);

    }
}
