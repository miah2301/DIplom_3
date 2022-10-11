import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends LoginPage{

    private final SelenideElement logoutButton = $x("//button[text()='Выход']");
    public String getEmailProfile(){
        return emailRegField.getValue();
    }

    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }
}
