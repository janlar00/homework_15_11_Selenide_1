package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SoftAssertionsTest extends BaseTest {

    @Test
    public void checkWhetherJunit5ExamplesExistTest() {
        step("Open Selenide page on Github", () -> {
            open("/selenide/selenide");
        });
        step("Elements check", () -> {
        $("#wiki-tab").click();
        $(".markdown-body h1").shouldHave(text("Welcome to the selenide wiki!"));
        $x("//button[contains(text(),'Show 2 more pages')]").click();
        $(".Layout-sidebar").$(withText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
        });
    }
}