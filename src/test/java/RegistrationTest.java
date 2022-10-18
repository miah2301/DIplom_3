import client.UserClient;
import com.codeborne.selenide.Selenide;
import emity.User;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest{

    UserClient userClient = new UserClient();
    private User user;
    private String accessToken;
    private final static String expectedErrorMessage = "Некорректный пароль";

    @Before
    public void setUp(){
        String URL = "https://stellarburgers.nomoreparties.site/";
        open(URL);
        user = User.getRandomUser();

        ValidatableResponse getToken = userClient.createUser(user);
        accessToken = StringUtils.substringAfter(getToken.extract().path("accessToken"), " ");
    }

    @DisplayName("Verification of successful registration with a random user")
    @Test
    public void successfulRegistration(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUser(user)
                .getTextEmailField();

        Assert.assertEquals(user.getEmail(), actual);
    }

    @DisplayName("Checking registration with a password less than 6 characters long")
    @Test
    public void checkErrorMessageBadPassword(){
        user.setPassword("123");

        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUserWithBadPassword(user);

        Assert.assertEquals(expectedErrorMessage, actual);
    }

    @After
    public void tearDown(){
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        Selenide.closeWebDriver();
    }
}
