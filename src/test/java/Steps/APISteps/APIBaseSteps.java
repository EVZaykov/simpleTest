package Steps.APISteps;

import config.TestConfig;
import groovy.util.logging.Slf4j;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.given;

@Slf4j
public class APIBaseSteps {

    TestConfig testConfig = new TestConfig();

    public Response postRequest(String body, String myPath) {
        if(body == null || body.isEmpty()) {
            body = "{}";
        }
        //log.info("body: " + body);
        Response response = given().filter(new AllureRestAssured()).body(body).header("Authorization","Bearer " + System.getenv("SECRET_TOKEN")).contentType("application/json;charset=UTF-8").post(myPath);
        //log.info(String.format("URL for request : \"%s\"", myPath));
        return response;
    }

    public Response getRequest(RequestSpecification specification, String url) {
        Response response = specification.get(url);
        //log.info(String.format("URL for request : \"%s\"", url));
        return response;
    }

    public JsonPath rawToJson(ValidatableResponse response) {
        String responseString = response.toString();
        return new JsonPath(responseString);
    }

    public double randomNumber() {
        return 20 + Math.random()*400;
    }
}
