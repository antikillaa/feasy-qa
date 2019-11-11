package io.severex.feasy.qa.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LandingPage {
    public SelenideElement signInToBetaButton = $(byXpath("//span[text()='Sign in to beta']/.."));
    private SelenideElement emailError = $(By.xpath("//div[text()='This email address does not look correct.']"));
    private SelenideElement confirmationPopup = $(By.xpath("//div[text()='Subscription Successfully Confirmed']"));
    private SelenideElement emailInputField = $(By.id("email"));

    public void checkEmailError() {
        emailError.shouldBe(Condition.visible);
    }

    public void checkConfirmationPopup() {
        confirmationPopup.shouldBe(Condition.visible);
    }

    public void setEmail(String string) {
        emailInputField.val(string);
    }

    public void clickSignInToBetaButton() {
        signInToBetaButton.click();
    }
}
