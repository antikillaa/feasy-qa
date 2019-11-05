package io.severex.feasy.qa.model.registration;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement becomeAuthorButton = $(By.xpath("//div[text()='Become an Author']"));

    private SelenideElement emailInputField = $(By.id("form_email"));
    private SelenideElement firstNameInputField = $(By.id("form_firstName"));
    private SelenideElement lastInputField = $(By.id("form_lastName"));
    private SelenideElement passwordInputField = $(By.id("form_password"));
    private SelenideElement agreementCheckBox = $(By.id("form_agreement"));
    private SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));


    public void setEmail(String string) {
        string = string + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
        emailInputField.val(string);
    }

    public void setFirstName(String string) {
        firstNameInputField.val(string);
    }

    public void setLastName(String string) {
        lastInputField.val(string);
    }

    public void setPassword(String string) {
        passwordInputField.val(string);
    }

    public void clickAgreementCheckBox() {
        agreementCheckBox.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickBecomeAuthorButton() {
        becomeAuthorButton.click();
    }
}
