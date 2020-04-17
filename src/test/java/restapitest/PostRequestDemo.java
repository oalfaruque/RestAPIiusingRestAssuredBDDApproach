package restapitest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

public class PostRequestDemo {
    //map is created to store data from RestUtilities Class
    public static HashMap myMap = new HashMap();
    @BeforeMethod
    public void requiredData(){
        //credentials are coming from RestUtilities Class
        myMap.put("name",RestUtilities.generateEmpName());
        myMap.put("salary", RestUtilities.generateEmpSalary());
        myMap.put("age", RestUtilities.generateEmpAge());

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/create";
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
                    .statusLine("HTTP/1.1 200 OK")
                    .body("status",equalTo("success"))
                    .log().all();//To get the result in the console
    }
}
