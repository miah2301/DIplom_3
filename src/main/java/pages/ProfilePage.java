package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends LoginPage{

    private final SelenideElement logoutButton = $x("//button[text()='Выход']");
    protected final SelenideElement loginField = $x("//label[text() = 'Логин']/following-sibling::input");
    public String getEmailProfile(){
        return loginField.getValue();
    }

    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }
}
