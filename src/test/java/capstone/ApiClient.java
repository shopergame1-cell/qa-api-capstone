package capstone;

import io.restassured.response.Response;

/**
 * Клієнт до публічного стенду JSONPlaceholder. TODO: реалізуй методи.
 *
 * Вимоги:
 *  - жодних URL у тестах — усе тут;
 *  - клієнт лише виконує запити й повертає Response, перевірки живуть у тестах;
 *  - методи не мусять самі кидати помилок на 404 — це нормальна відповідь.
 */
public class ApiClient {

    public static final String BASE_URI = "https://jsonplaceholder.typicode.com";

    /** GET /posts/1 */
    public Response getPost(int id) {
        throw new UnsupportedOperationException("TODO: GET /posts/{id}");
    }

    /** GET /posts?userId=1 */
    public Response getPostsByUser(int userId) {
        throw new UnsupportedOperationException("TODO: GET /posts з query-параметром userId");
    }

    /** GET /users/1 */
    public Response getUser(int id) {
        throw new UnsupportedOperationException("TODO: GET /users/{id}");
    }

    /** POST /posts з JSON-тілом {title, body, userId} */
    public Response createPost(String title, String body, int userId) {
        throw new UnsupportedOperationException("TODO: POST /posts з JSON-тілом");
    }

    /** GET /posts/{id} для неіснуючого id (очікуємо 404) */
    public Response missingPost(int id) {
        throw new UnsupportedOperationException("TODO: GET /posts/{id}");
    }
}
