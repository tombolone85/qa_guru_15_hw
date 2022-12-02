package lesson_13_jenkins.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;


import com.codeborne.selenide.SelenideElement;
import lesson_13_jenkins.tests.JenkinsParameterizedTest;

public class SearchPage {

    private final SelenideElement repoLink = $(linkText(JenkinsParameterizedTest.REPONAME));

    public SearchPage repoLinkClick() {
        repoLink.click();
        return this;
    }
}