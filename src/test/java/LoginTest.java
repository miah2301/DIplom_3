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

    @Test
    public void loginFromButtonMainPage(){
        String actual = new HomePage(URL)
                .clickOnLoginButtonMainPage()
                .loginUser()
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @Test
    public void loginFromPersonalAccountButton(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .loginUser()
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @Test
    public void loginFromRegistrationLink(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .clickLoginLink()
                .loginUser()
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @Test
    public void loginFromRecoverLink(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickRecoverPasswordLink()
                .clickLoginLinkRecover()
                .loginUser()
                .getEmailProfile();

        Assert.assertEquals(TEST_EMAIL, actual);
    }
}
