package util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class TestBase {

//    @BeforeClass
//    public static void setBaseUri () {
//
//        RestAssured.baseURI = "https://my-json-server.typicode.com";
//        RestAssured.basePath = "/typicode/demo/posts";
//
//    }

    @BeforeClass
    public static void setBaseUri () {

        RestAssured.baseURI = "https://samples.openweathermap.org";
    }
}
