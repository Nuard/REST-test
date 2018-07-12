package weatherapitest;

import org.junit.Test;
import util.TestBase;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetData extends TestBase {

    @Test
    public void testGet() {
        given().when().get("/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").andReturn().prettyPrint();
    }

    @Test
    public void testGetBody() {
        given().when().get("/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().body("sys.country",equalTo("GB"));
    }

    @Test
    public void testGetBodyContains() {
        given().when().get("/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().body(containsString("id"));
    }

    @Test
    public void testGetResponseStatusCode() {
        given().when().get().then().statusCode(200);
    }
}




