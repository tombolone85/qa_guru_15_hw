import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase{
    @Test
    public void testIssueSearch() {

        open("/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("tombolone85/qa_guru_15_lesson3");
        $(".header-search-input").submit();

        $(linkText("tombolone85/qa_guru_15_lesson3")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
