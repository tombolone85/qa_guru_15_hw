package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import guru.qa.data.Locale;
import guru.qa.data.Queries;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HWTests {
    @CsvSource({
            "мыши, Коврик для мыши Mouse Pad — серия Studio",
            "клавиатуры, Беспроводная клавиатура Logitech ERGO K860 с разделенным буквенно-цифровым блоком клавиш"
    })
    @ParameterizedTest(name = "Query of production of category {0} at logitech.com/ru-ru")
        void checkLogiTest(String searchText, String expectedText){
            open("https://www.logitech.com/ru-ru");
            $("button[aria-label='Поиск']").click();
            $("#searchInput").setValue(searchText).pressEnter();
            $$("a[class='search-result-product-wrapper")
                    .first()
                    .shouldHave(text(expectedText));
        }

    @ValueSource(strings = {"Timeo Danaos et dona ferentes", "Para bellum"})

    @ParameterizedTest(name = "Search for article {0}  at ru.wikipedia.org")
    void WikiSearchTest(String articles){
        open("https://ru.wikipedia.org/wiki/");
        $("input[name='search']").setValue(articles).pressEnter();
        $$("li[class=\"mw-search-result\"]")
                .first()
                .shouldHave(text(articles));
    }

    @EnumSource(Queries.class)
    @ParameterizedTest(name = "Search for production {0} at aramid.ru")
    void checkLocalesTest(Queries query){
        open("https://aramid.ru/ru/content/nasha-produkciya");
        $$("div[class='prod-desc']").find(text(query.name())).shouldBe(visible);;
    }
}