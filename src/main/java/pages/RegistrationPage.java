package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage{
    private final SelenideElement nameRegField = $x("//label[text() = 'Имя']/following-sibling::input");
    private final SelenideElement buttonRegistration = $x("//button[text() = 'Зарегистрироваться']");
    private final SelenideElement errorPasswordMessage = $x("//p[text() = 'Некорректный пароль']");
    private final SelenideElement loginLinkRegistration = $x("//a[@class = 'Auth_link__1fOlj']");

    LoginPage loginPage = new LoginPage();

    public LoginPage registrationNewUser(String name, String email, String password){
        nameRegField.setValue(name);
        loginPage.emailRegField.setValue(email);
        loginPage.passwordRegField.setValue(password);
        buttonRegistration.click();
        return new LoginPage();
    }

    public String registrationNewUserWithBadPassword(String name, String email, String password){
        nameRegField.setValue(name);
        loginPage.emailRegField.setValue(email);
        loginPage.passwordRegField.setValue(password);
        buttonRegistration.click();
        return errorPasswordMessage.getText();
    }

    public LoginPage clickLoginLink(){
        loginLinkRegistration.click();
        return new LoginPage();
    }
}
