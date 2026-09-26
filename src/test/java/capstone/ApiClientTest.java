package capstone;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/** 5 API-тестів, які мусять стати зеленими. */
class ApiClientTest {

    private final ApiClient api = new ApiClient();

    @Test
    @DisplayName("1. GET /posts/1 повертає 200 і правильний id")
    void getPostReturnsCorrectId() {
        Response response = api.getPost(1);
        assertEquals(200, response.statusCode(), "статус мусить бути 200");
        assertEquals(1, response.jsonPath().getInt("id"), "id у відповіді мусить бути 1");
        assertFalse(response.jsonPath().getString("title").isBlank(), "title не мусить бути порожнім");
    }

    @Test
    @DisplayName("2. GET /posts?userId=1 повертає рівно 10 постів цього користувача")
    void postsFilteredByUser() {
        Response response = api.getPostsByUser(1);
        assertEquals(200, response.statusCode());
        List<Integer> userIds = response.jsonPath().getList("userId", Integer.class);
        assertEquals(10, userIds.size(), "у користувача 1 мусить бути 10 постів");
        assertTrue(userIds.stream().allMatch(id -> id == 1), "усі пости мусять належати користувачу 1");
    }

    @Test
    @DisplayName("3. POST /post повертає наше тіло назад у полі json")
    void postEchoesJsonBody() {
        Response response = api.postJson("mentorship", 42);
        assertEquals(200, response.statusCode());
        assertEquals("mentorship", response.jsonPath().getString("json.name"));
        assertEquals(42, response.jsonPath().getInt("json.value"));
    }

    @Test
    @DisplayName("4. GET /status/200 повертає 200")
    void statusEndpoint() {
        assertEquals(200, api.status(200).statusCode());
    }

    @Test
    @DisplayName("5. GET неіснуючого поста повертає 404")
    void missingPostReturns404() {
        assertEquals(404, api.missingPost(999999).statusCode(), "неіснуючий пост мусить давати 404");
    }
}
