package restapitest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class PutRequestDemo {

    public static HashMap myMap = new HashMap();

    @BeforeMethod
    public void setUp(){
        myMap.put("name",RestUtilities.generateEmpName());
        myMap.put("salary", RestUtilities.generateEmpSalary());
        myMap.put("age", RestUtilities.generateEmpAge());
        int empID = 78;

        baseURI= "http://dummy.restapiexample.com/api/v1";
        basePath = "/update/"+empID;
    }
    
    @Test
    public void firstPutEmployeesRequest(){
        given()
                .contentType("application/json")
                .body(myMap)
                .when()
                    .put()
                .then()
                    .statusCode(200)
                    .statusLine("HTTP/1.1 200 OK")
                    .log().all();
    }
}
