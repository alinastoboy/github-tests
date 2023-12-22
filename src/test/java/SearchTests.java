import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTests {
    @BeforeAll
    static void setup(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    @DisplayName("Check label successful search")
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        step("Open vain page",()->
                open("https://github.com/"));
        step("Type search",()-> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue("qa.guru").pressEnter();
            });
        step("Check search results",()->
            $("[data-testid=\"results-list\"]").shouldHave(text("qa-guru/niffler")));

    }
    @Test
    void unsuccessfulSearchTest() {

    }
}