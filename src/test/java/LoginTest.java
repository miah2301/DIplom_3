import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import pages.HomePage;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest{
    private final String TEST_EMAIL = "testemail123@yandex.ru";
    private final String TEST_PASSWORD = "password1234";

    @Before
    public void setUp(){
        String URL = "https://stellarburgers.nomoreparties.site/";
        open(URL);
    }

    @DisplayName("Login using the -Login to account- button on the main page")
    @Test
    public void loginFromButtonMainPage(){
        String actual = new HomePage()
                .clickOnLoginButtonMainPage()
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("Login via the -Personal Account- button")
    @Test
    public void loginFromPersonalAccountButton(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("Login via the button in the registration form")
    @Test
    public void loginFromRegistrationLink(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .clickLoginLink()
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("Login via the button in the password recovery form")
    @Test
    public void loginFromRecoverLink(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickRecoverPasswordLink()
                .clickLoginLinkRecover()
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
