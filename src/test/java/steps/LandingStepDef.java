package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.model.LandingPage;
import org.apache.commons.lang3.RandomStringUtils;

public class LandingStepDef {

    private LandingPage landingPage = new LandingPage();


    @And("Input Invalid Email in Enter your email address")
    public void inputInvalidEmailInEnterYourEmailAddress() {
        landingPage.setEmail("email");
    }

    @And("Input Valid Email in Enter your email address")
    public void inputValidEmailInEnterYourEmailAddress() {
        String email = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
        landingPage.setEmail(email);
    }

    @Then("Click Sign in to beta button")
    public void clickSignInToBetaButton() {
        landingPage.signInToBetaButton.click();
    }

}
