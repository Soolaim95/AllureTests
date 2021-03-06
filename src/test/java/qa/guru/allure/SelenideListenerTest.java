package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideListenerTest {

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
    @Owner("polyakovaea")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Задачи в репозитории") //название функциональности
    @Story("Создание новой задачи") //краткое общее описание для группировки тестов
    @DisplayName("Проверка наличия созданного Issue в репозитории")
    @Description(
            "Этот тест проверяет создание Issue, когда происходит..."
    ) //подробное описание
    @Link(value = "github", url = "https://github.com") //url тестируемой страницы

    public void testIssueExist() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".header-search-input").setValue("Soolaim95/AllureTests").submit();
        $(By.linkText("Soolaim95/AllureTests")).click();
        $(By.partialLinkText("Issues")).click();
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        $(withText("Test Title")).should(Condition.exist);
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
    }
}