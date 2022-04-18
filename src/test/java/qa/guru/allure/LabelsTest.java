package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("polyakovaea")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("«адачи в репозитории") //название функциональности
    @Story("—оздание новой задачи") //краткое описание
    @DisplayName("ѕроверка создани€ Issue дл€ авторизованного пользовател€")
    @Description(
            "Ётот тест провер€ет создание Issue, когда происходит..."
    ) //подробное описание
    @Link(value = "Testing", url = "https://github.com") //url тестируемой страницы

    public void testAnnotatedLabels() {

    }

}
