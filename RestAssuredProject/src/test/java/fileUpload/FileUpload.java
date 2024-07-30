package fileUpload;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.then;;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;


public class FileUpload {

    @Test
    void uploadSingleFile()
    {
        File myfile= new File("C:\\Users\\Anuj\\Desktop\\stores.json");
//        File myfile2= new File("C:\\Users\\Anuj\\Desktop\\stores.json");


        given()
                .multiPart("file",myfile)
//                .multiPart("files",myfile2)
//                .contentType("multipart/form-data")
                .when()
            .post("http://localhost:8080/uploadFile")
            .then()
            .statusCode(200)
            .body("fileName",equalTo("stores.json")
//                            .body("[0].fileName",equalTo("stores.json"))
//                            .body("[1].fileName",equalTo("stores.json"))

                    ).log().all();


    }

//    void uploadSingleFiles2()
//    {
//        File myfile= new File("C:\\Users\\Anuj\\Desktop\\students.json");
//        File myfile2= new File("C:\\Users\\Anuj\\Desktop\\stores.json");
//        File fileArr[]={myfile,myfile2};
//
//
//        given()
//                .multiPart("file",myfile)
//                .multiPart("files",myfile2)
//                .contentType("multipart/form-data")
//                .when()
//                .post("http://localhost:8080/uploadFile")
//                .then()
//                .statusCode(200)
////                .body("fileName",equalTo("stores.json"))
//                            .body("[0].fileName",equalTo("students.json"))
//                            .body("[1].fileName",equalTo("stores.json"))
//
//                .log().all();


//    }

    @Test
    void fileDownload(){
        given().when()
                .get("http://localhost:8080/downloadFile/stores.json").then()
                .statusCode(200)
                .log().body();

    }
}
