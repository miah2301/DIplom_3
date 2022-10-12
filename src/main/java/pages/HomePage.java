package pages;

import com.codeborne.selenide.SelenideElement;
import constants.Constants;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends Constants {

    public HomePage(String url) {
        open(url);
    }

    private final SelenideElement personalAccountButton = $x("//p[text() = 'Личный Кабинет']");
    private final SelenideElement loginButtonMainPage = $x("//button[text() = 'Войти в аккаунт']");

    public LoginPage clickOnPersonalAccountButton(){
        personalAccountButton.click();
        return new LoginPage();
    }

    public LoginPage clickOnLoginButtonMainPage(){
        loginButtonMainPage.click();
        return new LoginPage();
    }


}
