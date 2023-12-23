package com.test.techtorialwork.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt", //location of failedTest for failure runners
        glue = "com/test/techtorialwork/stepdefinitions",//source root of step definitions
        tags = "@regression",
        plugin ={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)
public class FailedRunner {
}
