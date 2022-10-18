package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RecoverPasswordPage{
    private final SelenideElement loginLinkRecover = $x("//a[text() = 'Войти']");

    public LoginPage clickLoginLinkRecover(){
        loginLinkRecover.click();
        return new LoginPage();
    }
}
