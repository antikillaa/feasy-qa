package io.severex.feasy.qa.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPopover {
    public SelenideElement signOutLink = $(byXpath("//div[text()='Sign Out']"));

}
