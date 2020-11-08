package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

       plugin = {
         "rerun:target/rerun.txt",
         "json:target/cucumber.json"
       },

        features = "src/test/resources/features",
     glue = "com/vytrack/step_defenitions",
     dryRun = false,
     //tags = "@parametrized_test"
      //tags = " @negative_login or @parametrized_test",
       // tags = "@login",
        //tags = "@calendar_Events"
        tags = "@negative_login",
        publish = true

       )
//if and we have to have two
// if or one of them


public class CucumberRunner {
}