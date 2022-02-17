package com.spartantest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/spartantest/step_definitions",
        dryRun = false,
        tags = "@etsy"
)
public class Cukesrunner extends AbstractTestNGCucumberTests {


}
