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

public class TransitionsTest{

    private static final String expectedText = "Вход";
    private static final String expectedHeading = "Соберите бургер";

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

    @DisplayName("Transfer to your personal account")
    @Test
    public void checkTransitionPersonalAccountButton(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .checkTextLogin();

        Assert.assertEquals(expectedText, actual);
    }

    @DisplayName("Switching from the personal account to the constructor via the logo")
    @Test
    public void checkLogoClick(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .loginUser(Login.from(user))
                .clickOnLogo();

        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("Transfer from your personal account to the constructor via -the constructor link-")
    @Test
    public void checkConstructorLink(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .loginUser(Login.from(user))
                .clickOrderLink()
                .clickOnConstructorLink();

        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("Check the exit by clicking the -Exit- button in your personal account")
    @Test
    public void logoutUser(){
        String actual = new HomePage()
                .clickOnLoginButtonMainPage()
                .loginUser(Login.from(user))
                .clickLogoutButton()
                .checkTextLogin();

        Assert.assertEquals(expectedText, actual);
    }

    @After
    public void tearDown(){
        userClient.deleteUser(accessToken);
        Selenide.closeWebDriver();
    }
}
