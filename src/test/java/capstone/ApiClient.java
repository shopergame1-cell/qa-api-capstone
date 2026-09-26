package capstone;

import io.restassured.response.Response;

/**
 * Клієнт для публічних стендів. TODO: реалізуй методи.
 *
 * Вимоги:
 *  - жодних хардкодів URL у тестах — усе тут;
 *  - перевірки (assertions) живуть у тестах, клієнт лише виконує запити;
 *  - методи повертають Response або готове значення.
 */
public class ApiClient {

    public static final String HTTPBIN = "https://httpbin.org";
    public static final String JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com";

    /** GET {JSONPLACEHOLDER}/posts/1 */
    public Response getPost(int id) {
        throw new UnsupportedOperationException("TODO: зроби GET /posts/{id} і поверни Response");
    }

    /** GET {JSONPLACEHOLDER}/posts?userId=1 */
    public Response getPostsByUser(int userId) {
        throw new UnsupportedOperationException("TODO: зроби GET /posts з query-параметром userId");
    }

    /** POST {HTTPBIN}/post з JSON-тілом */
    public Response postJson(String name, int value) {
        throw new UnsupportedOperationException("TODO: надішли JSON {"name": name, "value": value} і поверни Response");
    }

    /** GET {HTTPBIN}/status/200 */
    public Response status(int code) {
        throw new UnsupportedOperationException("TODO: зроби GET /status/{code}");
    }

    /** GET {JSONPLACEHOLDER}/posts/{id} для неіснуючого id */
    public Response missingPost(int id) {
        throw new UnsupportedOperationException("TODO: зроби GET /posts/{id} (очікуємо 404)");
    }
}
