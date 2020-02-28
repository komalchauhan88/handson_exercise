package test.java.com.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OAuthAPITest {

    //unauthorized test
    @Test
    public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
        given().param("email", "email")
                .when().get("/url")
                .then().statusCode(401);
    }

    //forbidden test
    @Test
    public void givenInvalidRole_whenGetSecureRequest_thenForbidden() throws Exception {
        String accessToken = obtainAccessToken("user1", "pass");
        given().param("email", "abc@yahoo.com")
                .header("Authorization", "Bearer " + accessToken)
                .when().get("/url")
                .then().statusCode(403);
    }

    //post and get test with valid token
    @Test
    public void givenToken_whenPostGetSecureRequest_thenOk() throws Exception {
        String accessToken = obtainAccessToken("admin", "admin");

        String content = "{\"email\":\"abc@yahoo.com\",\"name\":\"abc\"}";

        //post request
        given().param("email", "abc@yahoo.com")
                .auth().oauth2(accessToken)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(content)
                .when().post("/url")
                .then().statusCode(200);

        //get request
        given().param("email", "abc@yahoo.com")
                .auth().oauth2(accessToken)
                .when().get("/url")
                .then().statusCode(200);
    }

    private String obtainAccessToken(String username, String password) throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("redirect_uri", "/redirect_URL");
        params.put("client_id", "clientIdPassword");
        params.put("username", username);
        params.put("password", password);

        Response response = given().params(params)
                .header("Authorization", "<client id>:<client secret>")
                .contentType(ContentType.JSON)
                .when()
                .post("/oauth/token");

        return response.jsonPath().get("access_token").toString();

    }

}
