import client.UserClient;
import emity.Login;
import emity.User;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import pages.HomePage;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.google.common.base.Ascii.toLowerCase;

public class LoginTest{
    private User user;
    private String accessToken;
    UserClient userClient = new UserClient();

    @Before
    public void setUp(){
        open(HomePage.URL);
        user = User.getRandomUser();

        ValidatableResponse getToken = userClient.createUser(user);
        accessToken = StringUtils.substringAfter(getToken.extract().path("accessToken"), " ");
    }

    @DisplayName("Login using the -Login to account- button on the main page")
    @Test
    public void loginFromButtonMainPage(){
        String actual = new HomePage()
                .clickOnLoginButtonMainPage()
                .loginUser(Login.from(user))
                .getEmailProfile();

        Assert.assertEquals(toLowerCase(user.getEmail()), actual);
    }

    @DisplayName("Login via the -Personal Account- button")
    @Test
    public void loginFromPersonalAccountButton(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .loginUser(Login.from(user))
                .getEmailProfile();

        Assert.assertEquals(toLowerCase(user.getEmail()), actual);
    }

    @DisplayName("Login via the button in the registration form")
    @Test
    public void loginFromRegistrationLink(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .clickLoginLink()
                .loginUser(Login.from(user))
                .getEmailProfile();

        Assert.assertEquals(toLowerCase(user.getEmail()), actual);
    }

    @DisplayName("Login via the button in the password recovery form")
    @Test
    public void loginFromRecoverLink(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickRecoverPasswordLink()
                .clickLoginLinkRecover()
                .loginUser(Login.from(user))
                .getEmailProfile();

        Assert.assertEquals(toLowerCase(user.getEmail()), actual);
    }

    @After
    public void tearDown(){
        userClient.deleteUser(accessToken);
        Selenide.closeWebDriver();
    }
}
