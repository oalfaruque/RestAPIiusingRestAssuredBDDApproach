package restapitest;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestDemo {

    @Test
    public void firstGetWeatherRequest(){
        given()
                .when()
                        .get("http://restapi.demoqa.com/utilities/weather/city/New York")
                .then()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK")
                        .assertThat().body("City", equalTo("New York"))
                        .header("Content-Type", "application/json");
    }
}
