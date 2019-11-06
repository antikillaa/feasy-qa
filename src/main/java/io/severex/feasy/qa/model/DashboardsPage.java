package io.severex.feasy.qa.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardsPage {
    private SelenideElement dashBardTitle;

    public String getDashBardTitle() {
        dashBardTitle = $(By.xpath("//h2"));
        dashBardTitle.waitUntil(Condition.visible, 60000);
        return dashBardTitle.getText();
    }
}
