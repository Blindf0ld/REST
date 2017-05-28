
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.junit.Test;




/**
 * Created by pc on 12.07.2016.
 */
public class RestTest {

    @Test
    public void firstRestTest(){
        //System.out.println(get("").getBody().prettyPrint());
        /*get("").then().assertThat().body("main.temp_min", greaterThan(20));
        get("").then().assertThat().body("main.temp_min", allOf(greaterThan(20)), lessThan(50));*/

        given().param("units", "metric").
                param("q", "London").
                /*param("lat", "50.43").
                param("lon", "30.51").*/
                param("appid", "82c8a6d21da39718af1b0bd42d63827d").
                get("http://api.openweathermap.org/data/2.5/weather").
                then().assertThat().body("main.temp_min", allOf(greaterThan(0f), lessThan(40f))).body("main.temp_max", allOf(greaterThan(0f), lessThan(40f)));
        given().param("units", "imperial").
                param("q", "London").
                param("lat", "50.43").
                param("lon", "30.51").
                param("appid", "82c8a6d21da39718af1b0bd42d63827d").
                get("http://api.openweathermap.org/data/2.5/weather").
                then().assertThat().body("main.temp_min", allOf(greaterThan(0f), lessThan(90f))).body("main.temp_max", allOf(greaterThan(0f), lessThan(90f)));
    }
}
