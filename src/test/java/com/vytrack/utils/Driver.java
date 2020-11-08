package com.vytrack.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {           //

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "remote-chrome":

                    try {
                        //ChromeOptions chromeOptions = new ChromeOptions();   can replace 42 43
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        URL gridUrl = new URL("http://54.174.183.38:4444/wd/hub");
                        driver = new RemoteWebDriver(gridUrl,desiredCapabilities);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                default:
                    throw new RuntimeException("No such a browser yet!");
            }
        }

        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }

    }



}
