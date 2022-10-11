import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends Constants{

    public HomePage(String url) {
        open(url);
    }

    private final SelenideElement personalAccountButton = $x("//p[text() = 'Личный Кабинет']");
    private final SelenideElement loginButtonMainPage = $x("//button[text() = 'Войти в аккаунт']");
    private final SelenideElement constructorLink = $x("//p[text() = 'Конструктор']");
    private final SelenideElement mainHeading = $x("//h1[text() = 'Соберите бургер']");
    private final SelenideElement logo = $x("//div[@class='AppHeader_header__logo__2D0X2']");

    public LoginPage clickOnPersonalAccountButton(){
        personalAccountButton.click();
        return new LoginPage();
    }

    public LoginPage clickOnLoginButtonMainPage(){
        loginButtonMainPage.click();
        return new LoginPage();
    }

    public String clickOnConstructorLink(){
        constructorLink.click();
        return mainHeading.getText();
    }

    public String clickOnLogo(){
        logo.click();
        return mainHeading.getText();
    }
}
