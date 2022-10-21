package client;

import constants.Constants;
import emity.Login;
import emity.User;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient{

    public ValidatableResponse createUser(User user) {
         return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(Constants.REG_API)
                .then()
                .log().all();

    }

    public void deleteUser(String accessToken){
        given()
                .header("Content-type", "application/json")
                .auth().oauth2(accessToken)
                .delete(Constants.DEL_API)
                .then()
                .log().all();
    }

    public ValidatableResponse loginUser(Login login){
        return given()
                .header("Content-type", "application/json")
                .body(login)
                .post(Constants.LOG_API)
                .then()
                .log().all();
    }
}
