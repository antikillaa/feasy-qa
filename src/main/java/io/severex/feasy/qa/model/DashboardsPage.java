package io.severex.feasy.qa.model;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardsPage {
    private String dashBardTitle;

    public String getDashBardTitle() {
        return $(By.xpath("//h2")).getText();
    }
}
