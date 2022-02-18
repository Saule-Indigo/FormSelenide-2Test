import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormSelenide2Test {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void testForm() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@gmail.com");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("7059005533");
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(byText("8")).click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("m").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#submit").scrollTo();
        $("#currentAddress").click();
        $("#currentAddress").setValue("Kazakhstan");
        $("#react-select-3-input").doubleClick();
        $("#react-select-3-input").setValue("N").pressEnter();
        sleep(500);
        $("#react-select-4-input").doubleClick();
        $("#react-select-4-input").setValue("D").pressEnter();
        $("#submit").click();


        //проверка значений

        $(".table-responsive").shouldHave(text("Ivan Ivanov"),
                text("ivanov@gmail.com"), text("Male"), text("7059005533"), text("08 March,2022"),
                text("Maths"), text("Music"), text("1.jpg"), text("Kazakhstan"), text("NCR Delhi"));
    }
}