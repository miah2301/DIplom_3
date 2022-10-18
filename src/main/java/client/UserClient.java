package client;

import emity.User;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient {
    public ValidatableResponse createUser(User user) {
         return given()
                .header("Content-type", "application/json")
                .body(user)
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then()
                .log().all();

    }

    public void deleteUser(String accessToken){
        given()
                .header("Content-type", "application/json")
                .auth().oauth2(accessToken)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .log().all();
    }
}
