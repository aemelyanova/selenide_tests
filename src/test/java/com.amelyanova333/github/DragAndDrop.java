package com.amelyanova333.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DragAndDrop {
    @Test
    void swapTrianglesWithDragAndDrop() {
        // - Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }

    @Test
    void checkWorkOperationActions() {
        // проверить работает ли тест, если вместо команды dragAndDrop использовать команду actions
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().moveToElement(elementA).click(elementB).perform();
        elementA.shouldHave(Condition.text("B"));
        elementB.shouldHave(Condition.text("A"));
        // с командой actions тест не работает
    }
}
