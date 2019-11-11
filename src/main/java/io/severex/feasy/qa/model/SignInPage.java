package io.severex.feasy.qa.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private SelenideElement emailInputField = $(By.id("form_email"));
    private SelenideElement passwordInputField = $(By.id("form_password"));
    private SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));
    public SelenideElement welcomeBackText = $(byXpath("//h1[text()='Welcome back']"));

    public void setEmail(String string) {
        emailInputField.val(string);
    }

    public void setPassword(String string) {
        passwordInputField.val(string);
    }

    public void clickSubmit() {
        submitButton.click();
    }

}
