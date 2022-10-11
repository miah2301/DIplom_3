import pages.HomePage;
import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

public class TransitionsTest extends Constants {

/*    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }*/

    private static final String expectedText = "Вход";
    private static final String expectedHeading = "Соберите бургер";

    @Test
    public void checkTransitionPersonalAccountButton(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .checkTextLogin();

        Assert.assertEquals(expectedText, actual);
    }

    @Test
    public void checkLogoClick(){
        String actual = new HomePage(URL_FEED)
                .clickOnLogo();

        Assert.assertEquals(expectedHeading, actual);
        System.out.println(expectedHeading);
    }

    @Test
    public void checkConstructorLink(){
        String actual = new HomePage(URL_FEED)
                .clickOnConstructorLink();

        Assert.assertEquals(expectedHeading, actual);
    }

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
