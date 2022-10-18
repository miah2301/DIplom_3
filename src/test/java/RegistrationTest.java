import io.qameta.allure.junit4.DisplayName;
import pages.HomePage;
import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends Constants {
    private final static String expectedErrorMessage = "Некорректный пароль";

    @DisplayName("Verification of successful registration with a random user")
    @Test
    public void successfulRegistration(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUser()
                .getTextEmailField();
        Assert.assertEquals(randomEmailUser, actual);
    }

    @DisplayName("Checking registration with a password less than 6 characters long")
    @Test
    public void checkErrorMessageBadPassword(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUserWithBadPassword();
        Assert.assertEquals(expectedErrorMessage, actual);
    }
}
