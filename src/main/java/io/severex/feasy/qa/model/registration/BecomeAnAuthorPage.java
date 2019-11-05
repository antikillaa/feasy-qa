package io.severex.feasy.qa.model.registration;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BecomeAnAuthorPage {
    private SelenideElement openTopicsSelect = $(By.xpath("//div[@id='form_topics']"));
    private SelenideElement chooseTopicSelect;
    private SelenideElement chooseSubTopicSelect;
    private SelenideElement titleInput = $(By.id("form_title"));
    private SelenideElement descriptionInput = $(By.id("form_overview"));
    private SelenideElement authorAgreementCheckBox = $(By.xpath("//input[@type='checkbox']"));


    public void setCategory(String string) {
        openTopicsSelect.click();
        chooseTopicSelect = $(By.xpath("//li[text()='" + string + "']"));
        chooseTopicSelect.click();
    }

    public void setSubcategory(String string) {
        openTopicsSelect.click();
        chooseSubTopicSelect = $(By.xpath("//li[text()='" + string + "']"));
        chooseSubTopicSelect.click();
    }

    public void setTitle(String string) {
        titleInput.val(string);
    }

    public void setDescription(String string) {
        descriptionInput.val(string);
    }

    public void clickAuthorAgreementCheckBox() {
        authorAgreementCheckBox.click();
    }

}
