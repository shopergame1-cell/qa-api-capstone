package capstone;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

/** Клієнт для публічних стендів (еталонна реалізація). */
public class ApiClient {

    public static final String HTTPBIN = "https://httpbin.org";
    public static final String JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com";

    public Response getPost(int id) {
        return RestAssured.given().baseUri(JSONPLACEHOLDER).get("/posts/" + id);
    }

    public Response getPostsByUser(int userId) {
        return RestAssured.given().baseUri(JSONPLACEHOLDER).queryParam("userId", userId).get("/posts");
    }

    public Response postJson(String name, int value) {
        return RestAssured.given()
                .baseUri(HTTPBIN)
                .contentType(ContentType.JSON)
                .body(Map.of("name", name, "value", value))
                .post("/post");
    }

    public Response status(int code) {
        return RestAssured.given().baseUri(HTTPBIN).get("/status/" + code);
    }

    public Response missingPost(int id) {
        return RestAssured.given().baseUri(JSONPLACEHOLDER).get("/posts/" + id);
    }
}
