package com.automation.automation_lab_03.cucumber_framework_01;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        dryRun = false,
        strict = true,
        plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"},
        tags = "@SmokeTest_review")


public class CucumberRun {

    //plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
}