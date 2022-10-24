import org.junit.jupiter.api.Test;

public class StepsTest extends TestBase{

    private static final String REPOSITORY = "tombolone85/qa_guru_15_lesson3";
    private static final int ISSUE = 1;

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openRepositoryPage(REPOSITORY);
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}
