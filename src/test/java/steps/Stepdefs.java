package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.model.HomePage;
import io.severex.feasy.qa.model.registration.BecomeAnAuthorPage;
import io.severex.feasy.qa.model.registration.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class Stepdefs {
    private HomePage homePage = new HomePage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private BecomeAnAuthorPage becomeAnAuthorPage = new BecomeAnAuthorPage();
    private String uri = "https://grinfer.com/";

    public void setUp() {
        Configuration.timeout = 60000;
    }

    @Given("Go to the {string} page")
    public void goToThePage(String arg0) {
        open(uri + arg0);
    }

    @Then("Click registration button")
    public void clickRegistrationButton() {
        homePage.registrationButton.should(Condition.visible);
        homePage.registrationButton.click();
    }

    @Then("Click become author button")
    public void clickBecomeAuthorButton() {
        registrationPage.becomeAuthorButton.waitUntil(Condition.visible, 60000);
        registrationPage.clickBecomeAuthorButton();
    }

    @And("Input First Name: {string}")
    public void inputFirstName(String arg0) {
        registrationPage.setFirstName(arg0);
    }

    @And("Input Last Name: {string}")
    public void inputLastName(String arg0) {
        registrationPage.setLastName(arg0);
    }

    @And("Input Email: {string}")
    public void inputEmail(String arg0) {
        registrationPage.setEmail(arg0);
    }

    @And("Input Password: {string}")
    public void inputPassword(String arg0) {
        registrationPage.setPassword(arg0);
    }

    @And("Check agreement checkbox")
    public void checkAgreementCheckbox() {
        registrationPage.clickAgreementCheckBox();
    }

    @Then("Click submit button")
    public void clickSubmitButton() {
        registrationPage.clickSubmit();
    }

    @Then("Choose {string} category")
    public void chooseCategory(String arg0) {
        becomeAnAuthorPage.setCategory(arg0);
    }

    @And("Choose {string} subcategory")
    public void chooseSubcategory(String arg0) {
        becomeAnAuthorPage.setSubcategory(arg0);
    }

    @And("Input title: {string}")
    public void inputTitle(String arg0) {
        becomeAnAuthorPage.setTitle(arg0);
    }

    @And("Input personal description: {string}")
    public void inputPersonalDescription(String arg0) {
        becomeAnAuthorPage.setDescription(arg0);
    }

    @And("Check author agreement checkbox")
    public void checkAuthorAgreementCheckbox() {
        becomeAnAuthorPage.clickAuthorAgreementCheckBox();
    }

    @Then("First name should be {string}")
    public void firstNameShouldBe(String arg0) {

    }

    @And("Last name should be {string}")
    public void lastNameShouldBe(String arg0) {
    }
}
