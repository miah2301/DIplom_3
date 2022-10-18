import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class TransitionsTest{

    private static final String expectedText = "Вход";
    private static final String expectedHeading = "Соберите бургер";
    private final String TEST_EMAIL = "testemail123@yandex.ru";
    private final String TEST_PASSWORD = "password1234";

    @Before
    public void setUp(){
        String URL = "https://stellarburgers.nomoreparties.site/";
        open(URL);
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
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .clickOnLogo();

        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("Transfer from your personal account to the constructor via -the constructor link-")
    @Test
    public void checkConstructorLink(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .clickOrderLink()
                .clickOnConstructorLink();

        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("Check the exit by clicking the -Exit- button in your personal account")
    @Test
    public void logoutUser(){
        String actual = new HomePage()
                .clickOnLoginButtonMainPage()
                .loginUser(TEST_EMAIL, TEST_PASSWORD)
                .clickLogoutButton()
                .checkTextLogin();

        Assert.assertEquals(expectedText, actual);
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
