package com.vytrack.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public static void wait(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted exception here");
        }
    }


    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickWithJS(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].click()", element);
    }


    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);

        // if not all text loaded

      //  wait.until(ExpectedConditions.attributeToBe(element,"value",text));
        // [java is great] --[java is g] selenium not fully enter data
        // we wait until text is complete entered
        //text is stored in the value atribute,
        // we wait when element will obtain text

        //this metod works when html has text - value attribute
        //in our case this text in <span> as text in paragraph


        System.out.println("Entering text: "+ text);
    }





}


