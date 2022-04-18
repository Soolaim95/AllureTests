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

}
