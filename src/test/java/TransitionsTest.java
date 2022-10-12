import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import pages.HomePage;
import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

public class TransitionsTest extends Constants {

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    private static final String expectedText = "Вход";
    private static final String expectedHeading = "Соберите бургер";

    @DisplayName("Transfer to your personal account")
    @Test
    public void checkTransitionPersonalAccountButton(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .checkTextLogin();

        Assert.assertEquals(expectedText, actual);
    }

    @DisplayName("Switching from the personal account to the constructor via the logo")
    @Test
    public void checkLogoClick(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .loginUser()
                .clickOnLogo();

        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("Transfer from your personal account to the constructor via -the constructor link-")
    @Test
    public void checkConstructorLink(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .loginUser()
                .clickOrderLink()
                .clickOnConstructorLink();

        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("Check the exit by clicking the -Exit- button in your personal account")
    @Test
    public void logoutUser(){
        String actual = new HomePage(URL)
                .clickOnLoginButtonMainPage()
                .loginUser()
                .clickLogoutButton()
                .checkTextLogin();

        Assert.assertEquals(expectedText, actual);
    }
}
