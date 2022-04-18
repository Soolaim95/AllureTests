package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

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
    public void testLambdaFSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим во вкладку Issues", () -> {
            $(By.partialLinkText("Issues")).click();
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        });
        step("Ищем Issue по названию " + ISSUE_TITLE, () -> {
            $(withText(ISSUE_TITLE)).should(Condition.exist);
        });
    }
}

