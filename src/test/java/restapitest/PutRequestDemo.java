package restapitest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class PutRequestDemo {

    public static HashMap myMap = new HashMap();

    @BeforeMethod
    public void setUp(){
        myMap.put("employee_name", RestUtilities.generateEmpName());
        myMap.put("employee_age", RestUtilities.generatedEmpAge());
        myMap.put("employee_salary", RestUtilities.generateEmpSalary());
        int empID = 23;

        baseURI= "http://dummy.restapiexample.com/api/v1/employees";
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
