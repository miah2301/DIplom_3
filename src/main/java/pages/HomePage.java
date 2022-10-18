package pages;

import com.codeborne.selenide.SelenideElement;
import constants.Constants;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage{

    private final SelenideElement rollsLinkAttribute = $x("//span[text()='Булки']/..");
    private final SelenideElement souseLink = $x("//span[text()='Соусы']");
    private final SelenideElement souseLinkAttribute = $x("//span[text()='Соусы']/..");
    private final SelenideElement fillingLink = $x("//span[text()='Начинки']");
    private final SelenideElement fillingLinkAttribute = $x("//span[text()='Начинки']/..");
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

    public String getRollsLinkAttribute(){
        return rollsLinkAttribute.getAttribute("class");
    }

    public String getSouseLinkAttribute(){
        souseLink.click();
        return souseLinkAttribute.getAttribute("class");
    }

    public String getFillingLinkAttribute(){
        fillingLink.click();
        return fillingLinkAttribute.getAttribute("class");
    }
}
