package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class Stepdefs {
    private String uri = "https://grinfer.com/";

    @Given("Go to the {string} page")
    public void goToThePage(String arg0) {
        open(uri + arg0);
    }
}
