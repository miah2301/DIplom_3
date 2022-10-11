import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage extends LoginPage{
    private final SelenideElement nameRegField = $x("//label[text() = 'Имя']/following-sibling::input");
    private final SelenideElement buttonRegistration = $x("//button[text() = 'Зарегистрироваться']");
    private final SelenideElement errorPasswordMessage = $x("//p[text() = 'Некорректный пароль']");
    private final SelenideElement loginLinkRegistration = $x("//a[@class = 'Auth_link__1fOlj']");

    public LoginPage registrationNewUser(){
        nameRegField.setValue(TEST_NAME);
        emailRegField.setValue(randomEmailUser);
        passwordRegField.setValue(TEST_Password);
        buttonRegistration.click();
        return new LoginPage();
    }

    public String registrationNewUserWithBadPassword(){
        nameRegField.setValue(TEST_NAME);
        emailRegField.setValue(TEST_EMAIL);
        passwordRegField.setValue("1234");
        buttonRegistration.click();
        return errorPasswordMessage.getText();
    }

    public LoginPage clickLoginLink(){
        loginLinkRegistration.click();
        return new LoginPage();
    }
}
