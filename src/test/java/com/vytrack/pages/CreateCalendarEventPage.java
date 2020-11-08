package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalendarEventPage extends BasePage {

    //- create calendar event button
    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEventsBtn;

    //    - title input box element

    //@FindBy(xpath = "//div[@data-name='field__title']")
    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement inputTitleBox;

    //   - description input box element
    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement descriptionInputBox;




    //    Create void method clickOnCreateCalendarEvenBtn()
    public void clickOnCreateCalendarEvenBtn(){
        BrowserUtils.clickOnElement(createCalendarEventsBtn);

    }

    //Create void method enterTitle(String value)
    public void enterTitle(String text){
        //inputTitleBox.sendKeys(text);
        BrowserUtils.enterText(inputTitleBox, text);
    }

    // Create void method enterDescription(String value)
    public void enterDescription(String text){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

        Driver.getDriver().switchTo().defaultContent();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        //BrowserUtils.enterText(descriptionInputBox, text);
        descriptionInputBox.sendKeys(text);

        Driver.getDriver().switchTo().defaultContent();

    }

    public String getDataFromGeneralInfo(String parameterName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath = "//label[text()='" + parameterName + "']/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();
    }








}
