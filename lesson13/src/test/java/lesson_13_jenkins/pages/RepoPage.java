package lesson_13_jenkins.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class RepoPage {

    private static final SelenideElement issueTab = $("#issues-tab");

    public RepoPage issueTabClick() {
        issueTab.click();
        return this;
    }

    public RepoPage checkIssueTitle(String name) {
        issueTab.shouldHave(text(name));
        return this;
    }
}