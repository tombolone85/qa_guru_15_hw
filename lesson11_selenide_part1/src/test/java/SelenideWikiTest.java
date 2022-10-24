import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiTest {
    @Test
    public void softAssertionsTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
//        $(".Box--condensed").$(".js-wiki-more-pages-link").click();
        $(".Box--condensed").$(".js-wiki-more-pages-link").click();
        $(".Box--condensed").shouldHave(text("SoftAssertions"));
        $(".Box--condensed").$(byText("SoftAssertions")).click();
        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).shouldBe(visible);
    }
}