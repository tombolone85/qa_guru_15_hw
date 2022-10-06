package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import guru.qa.data.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @ValueSource(strings = {"Selenide", "Junit"})

    @ParameterizedTest(name = "Проверка поиска Яндекса для запроса {0} ")
    void yandexSearchCommonTest(String testData){
         open("https://ya.ru");
         $("#text").setValue(testData);
         $("button[type='submit']").click();
         $$("li.serp-item")
                 .first()
                 .shouldHave(text(testData));
    }
        @CsvSource({
                "Selenide in english, Selenide is really nice and capable tool for writing functional/acceptance tests",
                "Junit in english, JUnit is a unit testing framework for the Java programming language"
        })

        @ParameterizedTest(name = "Проверка поиска Яндекса для запроса {0} с ожидаемым текстом {1}")
        void yandexSearchCommonTestWithExpectedText(String searchQuery,String expectedText){
         open("https://ya.ru");
         $("#text").setValue(searchQuery);
         $("button[type='submit']").click();
         $$("li.serp-item")
                 .first()
                 .shouldHave(text(expectedText));
    }
    //дата-провайдер
    static Stream<Arguments> selenideSiteButtonsText(){
       //возвращаем столько раз аргументы, сколько раз будем запускать тест
        // Arguments.of()-один набор параметров для запуска нашего теста
        return Stream.of(
                Arguments.of(Locale.EN,List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc","Пользователи", "Отзывы"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка текста кнопок selenide.org с локалью {0}")
    void selenideSiteButtonsText(Locale locale, List<String> buttonsTexts){
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsTexts));
    }

    @EnumSource(Locale.class)
    @ParameterizedTest(name = "На сайте присутствует локаль {0}")
    void checkLocalesTest(Locale locale){
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).shouldBe(visible);
    }
}
