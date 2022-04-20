package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("polyakovaea")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Задачи в репозитории") //название функциональности
    @Story("Создание новой задачи") //краткое описание
    @DisplayName("Проверка создания Issue для авторизованного пользователя")
    @Description(
            "Этот тест проверяет создание Issue, когда происходит..."
    ) //подробное описание
    @Link(value = "Testing", url = "https://github.com") //url тестируемой страницы

    public void testAnnotatedLabels() {

    }

    //продвинутый вариант (более динамический)
    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "polyakovaea");
        Allure.label("severity", SeverityLevel.MINOR.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Удаление новой задачи");
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Проверка удаления Issue для авторизованного пользователя");
        });
        Allure.description("Этот тест проверяет удаление Issue, когда происходит....");
        Allure.link("github", "https://github.com");
    }

    //входные параметры для отображения в отчете
    @Test
    public void testParameters() {
        Allure.parameter("Регион", "Ленинградская область");
        Allure.parameter("Город", "Выборг");
    }
}
