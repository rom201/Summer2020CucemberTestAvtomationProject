package com.vytrack.pages;

import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    // do not use web elements exactly in step defenitions
    // helps to prevent duplication code
    @FindBy(id ="prependedInput")
    private WebElement username;


   @FindBy(id ="prependedInput2" )
    private WebElement password;
    
    //private By password = By.id("prependedInput2");



    @FindBy(css ="[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warningMessage.getText().trim();
    }

    public void getUrl(){
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }



    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("storemanager.username");
        String passwordValue = ConfigurationReader.getProperty("password");
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);

    }

    public void login(String role){
        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");
        if(role.equalsIgnoreCase("sales manager")){
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        }else if(role.equalsIgnoreCase("driver")){
            usernameValue = ConfigurationReader.getProperty("driver.username");
        }else {
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);

    }


    public String getExpectedTitle(String role){
         if(role.equalsIgnoreCase("driver")){
            expectedTitle = "Quick Launchpad";
        }else  {
           expectedTitle = "Dashboard";
        }
        return expectedTitle;

    }

    public String getExpectedTitle(){
            expectedTitle = "Dashboard";
        return expectedTitle;

    }




}
