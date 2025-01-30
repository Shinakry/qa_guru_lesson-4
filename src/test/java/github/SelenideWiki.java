package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWiki {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void searchWikiSelenideInfoJUnitCode(){
        open("https://github.com/selenide/selenide/");
        $("#wiki-tab").click();
        $("[data-filterable-for=wiki-pages-filter]").$(".wiki-more-pages-link").$(".Link--muted").click();
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
