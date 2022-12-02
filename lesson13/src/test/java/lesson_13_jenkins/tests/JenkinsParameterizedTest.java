package lesson_13_jenkins.tests;

import io.qameta.allure.*;
import lesson_13_jenkins.BaseTest;
import lesson_13_jenkins.steps.WebSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JenkinsParameterizedTest extends BaseTest {
    public static final String REPONAME = "janlar00/homework_15_13_Jenkins";
    private static final String ISSUENAME = "Issues";
    WebSteps webSteps = new WebSteps();

    @Test
    @Feature("Issue в репозитории")
    @Story("Создать issue")
    @Owner("jan")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Проверить имя issue – тест с аннотацией @Step")
    public void checkIssueNameWithAnnotationStep() {
        webSteps.openMainPage();
        webSteps.searchForRepository(REPONAME);
        webSteps.clickOnRepositoryLink();
        webSteps.openIssuesTab();
        webSteps.checkIssueTitle(ISSUENAME);

    }

}