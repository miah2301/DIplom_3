package pages;

import com.codeborne.selenide.SelenideElement;
import emity.User;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage{
    private final SelenideElement nameRegField = $x("//label[text() = 'Имя']/following-sibling::input");
    private final SelenideElement buttonRegistration = $x("//button[text() = 'Зарегистрироваться']");
    private final SelenideElement errorPasswordMessage = $x("//p[text() = 'Некорректный пароль']");
    private final SelenideElement loginLinkRegistration = $x("//a[@class = 'Auth_link__1fOlj']");

    LoginPage loginPage = new LoginPage();

    public LoginPage registrationNewUser(User user){
        nameRegField.setValue(user.getName());
        loginPage.emailRegField.setValue(user.getEmail());
        loginPage.passwordRegField.setValue(user.getPassword());
        buttonRegistration.click();
        return new LoginPage();
    }

    public String registrationNewUserWithBadPassword(User user){
        nameRegField.setValue(user.getName());
        loginPage.emailRegField.setValue(user.getEmail());
        loginPage.passwordRegField.setValue(user.getPassword());
        buttonRegistration.click();
        return errorPasswordMessage.getText();
    }

    public LoginPage clickLoginLink(){
        loginLinkRegistration.click();
        return new LoginPage();
    }
}
