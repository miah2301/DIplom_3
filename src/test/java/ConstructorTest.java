import com.codeborne.selenide.SelenideElement;
import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.$x;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTest extends Constants {
    private final SelenideElement rollsLinkAttribute = $x("//span[text()='Булки']/..");
    private final SelenideElement souseLink = $x("//span[text()='Соусы']");
    private final SelenideElement souseLinkAttribute = $x("//span[text()='Соусы']/..");
    private final SelenideElement fillingLink = $x("//span[text()='Начинки']");
    private final SelenideElement fillingLinkAttribute = $x("//span[text()='Начинки']/..");

    @Before
    public void setUp(){
        new HomePage(URL);
    }
    private final String activeCategory = "tab_tab_type_current__2BEPc";

    @DisplayName("Transitions to sections work -Rolls-")
    @Test
    public void clickRolls(){
        String classActiveField = rollsLinkAttribute.getAttribute("class");

        assertThat(classActiveField, containsString(activeCategory));
    }

    @DisplayName("Transitions to sections work -Souse-")
    @Test
    public void clickSouse(){
        souseLink.click();
        String classActiveField = souseLinkAttribute.getAttribute("class");

        assertThat(classActiveField, containsString(activeCategory));
    }

    @DisplayName("Transitions to sections work -Filling-")
    @Test
    public void clickFilling(){
        fillingLink.click();
        String classActiveField = fillingLinkAttribute.getAttribute("class");

        assertThat(classActiveField, containsString(activeCategory));
    }
}
