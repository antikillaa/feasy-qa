package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.model.SignInPage;

public class SignInStepDef {
    private SignInPage signInPage = new SignInPage();

    @Then("Sign in page is opened")
    public void signInPageIsOpened() {
        signInPage.welcomeBackText.shouldBe(Condition.visible);
    }
}
