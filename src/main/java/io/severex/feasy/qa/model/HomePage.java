package io.severex.feasy.qa.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement registrationButton = $(byXpath("//button[@type='button']/span[text()='Registration']/.."));
    public SelenideElement signInLink = $(byXpath("//div[text()='Sign in']"));
    public SelenideElement avatarButton = $(byXpath("//span[contains(@class, 'ant-avatar')]/.."));

}
