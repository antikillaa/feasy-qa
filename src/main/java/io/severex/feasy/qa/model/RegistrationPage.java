package io.severex.feasy.qa.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement becomeAuthorButton = $(By.xpath("//div[text()='Become an Author']"));

    private SelenideElement emailInputField = $(By.id("form_email"));

    public void setEmailInputField(String string) {
        emailInputField.val(string);
    }

    @FindBy(how=How.ID, using="form_firstName")
    private SelenideElement firstNameInputField;


    @FindBy(how=How.ID, using="form_lastName")
    private SelenideElement lastInputField;


    @FindBy(how=How.ID, using="form_password")
    private SelenideElement passwordInputField;


    @FindBy(how=How.ID, using="form_agreement")
    private SelenideElement agreementCheckBox;


    @FindBy(how= How.XPATH, using="//button[@type='submit']")
    private SelenideElement submitButton;

    public void searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
    }
}
