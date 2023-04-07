package com.amelyanova333.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprise {
    @Test
    void hoverForSolutionsHeaderCheck() {
        // Открыть главную страницу GitHub
        open("https://github.com/");

        // Выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        $(".Header-old").$(byText("Solutions")).click();
        $(".border-bottom").$(byText("Enterprise")).click();

        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $(".application-main ").shouldHave(text("Build like the best"));
    }
}
