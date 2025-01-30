package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenide(){
        open("https://github.com");
        $("[placeholder='Search or jump to...']").click();
        $("[name='query-builder-test']").setValue("selenide").pressEnter();
        $$("div.gZKkEq div").first().$("a").click();
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
        sleep(5000);

    }
}
