import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import pages.HomePage;
import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest{
    private final static String expectedErrorMessage = "Некорректный пароль";
    private static final String randomEmailUser = RandomStringUtils.randomAlphanumeric(15) + "@yandex.ru";
    private final String TEST_EMAIL = "testemail123@yandex.ru";
    private final String TEST_NAME = "testName";

    @Before
    public void setUp(){
        String URL = "https://stellarburgers.nomoreparties.site/";
        open(URL);
    }

    @DisplayName("Verification of successful registration with a random user")
    @Test
    public void successfulRegistration(){
        String TEST_PASSWORD = "password1234";

        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUser(TEST_NAME, TEST_EMAIL, TEST_PASSWORD)
                .getTextEmailField();

        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("Checking registration with a password less than 6 characters long")
    @Test
    public void checkErrorMessageBadPassword(){
        String actual = new HomePage()
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registrationNewUserWithBadPassword(TEST_NAME, TEST_EMAIL, "123");

        Assert.assertEquals(expectedErrorMessage, actual);
    }
}
