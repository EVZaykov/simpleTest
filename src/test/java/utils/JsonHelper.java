package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonHelper {

    public static JsonPath rawToJson(Response response) {
        String responseString = response.asString();
        return new JsonPath(responseString);
    }
}
