import client.UserClient;
import com.codeborne.selenide.Selenide;
import emity.Login;
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
    private final static String expectedErrorMessage = "Некорректный пароль";
    private final static String expectedButtonText = "Войти";

    @Before
    public void setUp(){
        open(HomePage.URL);
        user = User.getRandomUser();
    }

    @DisplayName("Verification of successful registration with a random user")
    @Test
    public void successfulRegistration(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUser(user)
                .getEnterText();

        Assert.assertEquals(expectedButtonText, actual);
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
        ValidatableResponse getToken = userClient.loginUser(Login.from(user));
        String accessToken = StringUtils.substringAfter(getToken.extract().path("accessToken"), " ");

        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        Selenide.closeWebDriver();
    }
}
