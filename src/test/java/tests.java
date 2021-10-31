import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class tests {

    @BeforeAll
    static void beforeALl () {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void selenideSearchTest() {
        //test of text inputs
        $(byId("firstName")).setValue("firstname");
        $(byId("lastName")).setValue("lastname");
        $(byId("userEmail")).setValue("useremail@test.com");
        $(byText("Male")).click();
        $(byId("userNumber")).setValue("1234567891");
        //test of calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1992");
        $(byAttribute("aria-label", "Choose Friday, January 31st, 1992")).click();
        //test of subject input
        $(byAttribute("id", "subjectsInput")).setValue("Acc").pressEnter();
        //test of checkboxes
        $(byText("Sports")).click();
        $(byText("Music")).click();
        //test of file
        $("#uploadPicture").uploadFile(new File("C:\\Users\\kananykhin_do\\IdeaProjects\\QA_task2\\src\\test\\resources\\cat.png"));
        //test of current address
        $(byAttribute("id", "currentAddress")).setValue("somewhere in Syberia");
        //test of State
        $("#state").click();
        $(byText("NCR")).click();
        //test of City
        $("#city").click();
        $(byText("Agra"));
        //press submit button
        $("#submit").click();


    }
}