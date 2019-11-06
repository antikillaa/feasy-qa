package steps;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.app_context.RunContext;
import io.severex.feasy.qa.model.DashboardsPage;
import io.severex.feasy.qa.model.HomePage;
import io.severex.feasy.qa.model.LoggedUserPopover;
import io.severex.feasy.qa.model.registration.BecomeAnAuthorPage;
import io.severex.feasy.qa.model.registration.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationStepDef {
    private RunContext context = new RunContext();

    private HomePage homePage = new HomePage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private BecomeAnAuthorPage becomeAnAuthorPage = new BecomeAnAuthorPage();
    private DashboardsPage dashboardsPage = new DashboardsPage();
    private LoggedUserPopover loggedUserPopover = new LoggedUserPopover();

    private String env = "stage";
    private String envUsername = "foo";
    private String envPassword = "bar";

    private String uri = "https://" + envUsername + ":" + envPassword + "@" + env + ".grinfer.com/";

    public static void setUp() {
        Configuration.timeout = 60000;
    }

    @Given("Go to the {string} page")
    public void goToThePage(String arg0) {
        open(uri + arg0);
    }

    @Then("Click registration button")
    public void clickRegistrationButton() {
        homePage.registrationButton.click();
    }

    @Then("Click become author button")
    public void clickBecomeAuthorButton() {
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

    @And("Input Email")
    public void inputEmail() {
        String email;
        if (context.get("email", String.class) == null) {
            email = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
            context.put("email", email);
        } else {
            email = context.get("email", String.class);
        }

        registrationPage.setEmail(email);
    }

    @And("Input Password")
    public void inputPassword() {
        registrationPage.setPassword("Password!1");
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
        String title = dashboardsPage.getDashBardTitle();
        Assert.assertTrue(title.contains(arg0));
    }

    @And("Last name should be {string}")
    public void lastNameShouldBe(String arg0) {
        String title = dashboardsPage.getDashBardTitle();
        Assert.assertTrue(title.contains(arg0));
    }

    @Then("Click Avatar link")
    public void clickAvatarLink() {
        homePage.avatarButton.click();
    }

    @And("Click Sign Out link")
    public void clickSignOutLink() {
        loggedUserPopover.signOutLink.click();
    }

    @Then("Click Sign In link")
    public void clickSignInLink() {
        homePage.signInLink.click();
    }
}
