package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasicStepDef {

    private String env = "stage";
    private String envUsername = "foo";
    private String envPassword = "bar";

    private String uri = "https://" + envUsername + ":" + envPassword + "@" + env + ".grinfer.com/";

    @Given("Go to the {string} page")
    public void goToThePage(String arg0) {
        close();
        open(uri + arg0);
    }

    @Given("Go to the main page")
    public void goToThePage() {
        close();
        open(uri);
    }

    @Then("{string} page is opened")
    public void pageIsOpened(String arg0) {
        Assert.assertTrue(url().contains(arg0));
    }
}
