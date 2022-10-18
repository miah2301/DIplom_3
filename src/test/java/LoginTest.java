import io.qameta.allure.junit4.DisplayName;
import pages.HomePage;
import com.codeborne.selenide.Selenide;
import constants.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends Constants {

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @DisplayName("Login using the -Login to account- button on the main page")
    @Test
    public void loginFromButtonMainPage(){
        String actual = new HomePage()
                .clickOnLoginButtonMainPage()
                .loginUser()
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("Login via the -Personal Account- button")
    @Test
    public void loginFromPersonalAccountButton(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .loginUser()
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
                .loginUser()
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
                .loginUser()
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }
}
