package com.vytrack.step_defenitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    //   hook before = @BeforeMethod in TestNG
    //    hook after = @AfterMethod in TestNG
    //    it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
    //    usually, we just use explicit and fluent waits.

    @Before
    public void setup(Scenario scenario){
        //System.out.println(scenario.getSourceTagNames()); // choosing annotation in scenario
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//    this hook will run only before scenarios with a tag @db

    /**
     * @db
     * Scenario: I don't know but here I'm connecting to DB
     * Given user runs following query "SELECT * ...."
     */

    @Before("@db")
    public void seyup(){
        System.out.println("::Connecting to the data base::");
    }

    @After("@db")
    public void dbTearDown(){
        System.out.println("::Disconecting from the database: ");
    }


    @After
    public void tearDown(Scenario scenario) {
        //close browser, close DB connection, close tunnel,capture screenshot of the error, etc..
        //this is a hook after
        //runs automatically after every test
        if (scenario.isFailed()){
            byte[] data = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        System.out.println(":::End of test execution:::");

    }


}
