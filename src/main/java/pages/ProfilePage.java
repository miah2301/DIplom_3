package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends LoginPage{

    private final SelenideElement logoutButton = $x("//button[text()='Выход']");
    protected final SelenideElement loginField = $x("//label[text() = 'Логин']/following-sibling::input");
    private final SelenideElement constructorLink = $x("//p[text() = 'Конструктор']");
    private final SelenideElement ordersLink = $x("//p[text() = 'Лента Заказов']");
    private final SelenideElement mainHeading = $x("//h1[text() = 'Соберите бургер']");
    private final SelenideElement logo = $x("//div[@class='AppHeader_header__logo__2D0X2']");
    private final SelenideElement rollsLink = $x("//span[text()='Булки']");

    public String getEmailProfile(){
        return loginField.getValue();
    }

    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }

    public String clickOnConstructorLink(){
        constructorLink.click();
        return mainHeading.getText();
    }

    public ProfilePage clickOrderLink(){
        ordersLink.click();
        return new ProfilePage();
    }

    public String clickOnLogo(){
        logo.click();
        return mainHeading.getText();
    }

    public void clickRolls(){
        rollsLink.click();
        String lol = rollsLink.getAttribute("class");
    }
}
