package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class AnnotationStepTest {

    private static final String REPOSITORY = "Soolaim95/AllureTests";
    private static final String ISSUE_TITLE = "Test Title";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void beforeEach() {
        open("https://github.com");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка названия Issue в репозитории")
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        AnnotationWebSteps steps = new AnnotationWebSteps();

        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssueTab();
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        steps.shouldExistIssueWithTitle(ISSUE_TITLE);
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");

        steps.takeScreenshot();
    }
}
