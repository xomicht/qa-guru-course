package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Training 2
 * Task - Write an autotest to check the data in the form https://demoqa.com/automation-practice-form
 **/

public class Training2 {
    @BeforeAll
    static void setConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkStudentRegistrationForm() {
        String firstName = "Name";
        String lastName = "Soname";
        String email = "123654@fgfgfg.wq";
        String mobileNumber = "9876543210";
        String location = "WWW Leningrad, SPB.ru";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue(mobileNumber);
        // $("#dateOfBirthInput").setValue(bDay);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1900");
        $("[aria-label='Choose Monday, October 1st, 1900']").click();
        $("#hobbies-checkbox-1").parent().click();
        $("#currentAddress").setValue(location);
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Other"),
                text(mobileNumber),
                text("01 October,1900"),
                text("Sports"),
                text(location),
                text("Rajasthan Jaipur")
        );


    }

}
