package client;

import constants.Constants;
import emity.User;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends Constants {
    public ValidatableResponse createUser(User user) {
         return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(REG_API)
                .then()
                .log().all();

    }

    public void deleteUser(String accessToken){
        given()
                .header("Content-type", "application/json")
                .auth().oauth2(accessToken)
                .delete(DEL_API)
                .then()
                .log().all();
    }
}
