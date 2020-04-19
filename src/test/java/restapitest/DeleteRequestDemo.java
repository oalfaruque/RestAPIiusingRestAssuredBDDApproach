package restapitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class DeleteRequestDemo {

    @Test
    public void firstDeleteRequest(){
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/"+78;

        Response response =//to store whole response in the 'response' variable.
        when()
             .delete()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all()
                .extract().response();

                String jsonToString=response.asString();//converting the json response into String
                Assert.assertEquals(jsonToString.contains("successfully! deleted Records"),true);

    }
}
