package com.test.techtorialwork.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WorkHook {

    public WebDriver driver;

    @Before//it must be imported from io.cucumber not from JUNIT****
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("work_url"));
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
