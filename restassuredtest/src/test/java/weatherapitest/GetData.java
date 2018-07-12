package weatherapitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
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

    @Test
    public void testPost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        JSONObject json = new JSONObject();
        json.put("name","john");
        json.put("job","qa");

        request.body(json.toJSONString());

        Response response = request.post("https://reqres.in/api/users");

        int code = response.getStatusCode();
        Assert.assertEquals(code, 201);

    }
}




