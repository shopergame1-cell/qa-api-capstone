package capstone;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

/** Клієнт до JSONPlaceholder (еталонна реалізація). */
public class ApiClient {

    public static final String BASE_URI = "https://jsonplaceholder.typicode.com";

    public Response getPost(int id) {
        return RestAssured.given().baseUri(BASE_URI).get("/posts/" + id);
    }

    public Response getPostsByUser(int userId) {
        return RestAssured.given().baseUri(BASE_URI).queryParam("userId", userId).get("/posts");
    }

    public Response getUser(int id) {
        return RestAssured.given().baseUri(BASE_URI).get("/users/" + id);
    }

    public Response createPost(String title, String body, int userId) {
        return RestAssured.given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(Map.of("title", title, "body", body, "userId", userId))
                .post("/posts");
    }

    public Response missingPost(int id) {
        return RestAssured.given().baseUri(BASE_URI).get("/posts/" + id);
    }
}
