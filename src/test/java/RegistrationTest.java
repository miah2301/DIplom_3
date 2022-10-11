import pages.HomePage;
import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends Constants {

    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final static String expectedErrorMessage = "Некорректный пароль";

    @Test
    public void successfulRegistration(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUser()
                .getTextEmailField();
        Assert.assertEquals(randomEmailUser, actual);
    }

    @Test
    public void checkErrorMessageBadPassword(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUserWithBadPassword();
        Assert.assertEquals(expectedErrorMessage, actual);
    }
}
