package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.model.MyCoursesPage;

public class MyCoursesStepDef {
    MyCoursesPage myCoursesPage = new MyCoursesPage();

    @Then("My Courses Link is displayed")
    public void myCoursesLinkIsDisplayed() {
        myCoursesPage.myCoursesLink.should(Condition.visible);
    }
}
