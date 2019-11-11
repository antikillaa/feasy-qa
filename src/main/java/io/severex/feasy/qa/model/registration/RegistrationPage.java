package io.severex.feasy.qa.model.registration;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private SelenideElement becomeAuthorButton = $(By.xpath("//div[text()='Become an Author']"));
    private SelenideElement becomeLearnerButton = $(By.xpath("//div[text()='Become a Learner']"));


    private SelenideElement emailInputField = $(By.id("form_email"));
    private SelenideElement firstNameInputField = $(By.id("form_firstName"));
    private SelenideElement lastInputField = $(By.id("form_lastName"));
    private SelenideElement passwordInputField = $(By.id("form_password"));
    private SelenideElement agreementCheckBox = $(By.id("form_agreement"));
    private SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));


    public void setEmail(String string) {
        emailInputField.val(string);
    }

    public SelenideElement getEmailInputField() {
        return emailInputField;
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

    public void clickBecomeLearnerButton() {
        becomeLearnerButton.click();
    }

}
