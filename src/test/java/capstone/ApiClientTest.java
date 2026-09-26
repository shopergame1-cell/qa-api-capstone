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
    @DisplayName("1. GET /posts/1: статус 200, id=1, title не порожній")
    void getPostReturnsCorrectIdAndTitle() {
        Response response = api.getPost(1);
        assertEquals(200, response.statusCode(), "статус мусить бути 200");
        assertEquals(1, response.jsonPath().getInt("id"), "id у відповіді мусить бути 1");
        assertFalse(response.jsonPath().getString("title").isBlank(), "title не мусить бути порожнім");
    }

    @Test
    @DisplayName("2. GET /posts?userId=1: рівно 10 постів, усі належать користувачу 1")
    void postsFilteredByUser() {
        Response response = api.getPostsByUser(1);
        assertEquals(200, response.statusCode());
        List<Integer> userIds = response.jsonPath().getList("userId", Integer.class);
        assertEquals(10, userIds.size(), "у користувача 1 мусить бути 10 постів");
        assertTrue(userIds.stream().allMatch(id -> id == 1), "усі пости мусять належати користувачу 1");
    }

    @Test
    @DisplayName("3. GET /users/1: статус 200, email схожий на email")
    void getUserHasEmail() {
        Response response = api.getUser(1);
        assertEquals(200, response.statusCode());
        String email = response.jsonPath().getString("email");
        assertNotNull(email, "email мусить бути у відповіді");
        assertTrue(email.contains("@"), "email мусить містити @");
    }

    @Test
    @DisplayName("4. POST /posts: стенд повертає наше тіло назад і новий id")
    void createPostEchoesBody() {
        Response response = api.createPost("capstone", "перевірка створення", 1);
        assertEquals(201, response.statusCode(), "створення ресурсу мусить давати 201");
        assertEquals("capstone", response.jsonPath().getString("title"));
        assertEquals("перевірка створення", response.jsonPath().getString("body"));
        assertTrue(response.jsonPath().getInt("id") > 0, "стенд мусить присвоїти id");
    }

    @Test
    @DisplayName("5. GET неіснуючого поста: 404")
    void missingPostReturns404() {
        assertEquals(404, api.missingPost(999999).statusCode(), "неіснуючий пост мусить давати 404");
    }
}
