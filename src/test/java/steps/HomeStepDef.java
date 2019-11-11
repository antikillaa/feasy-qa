package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.model.HomePage;

public class HomeStepDef {
    private HomePage homePage = new HomePage();

    @Then("Registration button is displayed")
    public void registrationButtonIsDisplayed() {
        homePage.registrationButton.should(Condition.visible);
    }

    @Then("User successfully registered popup displayed")
    public void userSuccessfullyPopupDisplayed() {
        homePage.userSuccessfullyCreatedPopup.should(Condition.visible);
    }

    @Then("Click become author link")
    public void clickBecomeAuthorLink() {
        homePage.becomeAnAuthorLink.click();
    }
}
