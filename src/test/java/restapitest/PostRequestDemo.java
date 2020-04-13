package restapitest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class PostRequestDemo {
    //map is created to store data from RestUtilities Class
    public static HashMap myMap = new HashMap();
    @BeforeMethod
    public void requiredData(){
        //credentials are coming from RestUtilities Class
        myMap.put("FirstName", RestUtilities.generateFirstName());
        myMap.put("LastName", RestUtilities.generateLastName());
        myMap.put("UserName", RestUtilities.generateUserName());
        myMap.put("Password", RestUtilities.generatePassword());
        myMap.put("EmailID", RestUtilities.generateEmaiId());

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RestAssured.basePath = "/register/";
    }
    @Test
    public void firstPostCustomerRequest(){
        given()
                .contentType("application/json")
                .body(myMap)
                .when()
                    .post()

                .then()
                    .statusCode(200)
                    .statusLine("HTTP/1.1 200 OK");
    }
}
