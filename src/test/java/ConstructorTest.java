import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTest {
    private final String activeCategory = "tab_tab_type_current__2BEPc";

    @Before
    public void setUp(){
        open(HomePage.URL);
    }

    @DisplayName("Transitions to sections work -Rolls-")
    @Test
    public void clickRolls(){
        String actual = new HomePage()
                .getRollsLinkAttribute();

        assertThat(actual, containsString(activeCategory));
    }

    @DisplayName("Transitions to sections work -Souse-")
    @Test
    public void clickSouse(){
        String classActiveField = new HomePage()
                .getSouseLinkAttribute();

        assertThat(classActiveField, containsString(activeCategory));
    }

    @DisplayName("Transitions to sections work -Filling-")
    @Test
    public void clickFilling(){
        String classActiveField = new HomePage()
                .getFillingLinkAttribute();

        assertThat(classActiveField, containsString(activeCategory));
    }
}
