package com.test.saucelab.stepdefinitions;

import com.test.saucelab.pages.SauceLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
       driver.get(url);
    }
    @When("User provides {string} and {string} to the SauceLoginPage")
    public void user_provides_and_to_the_sauce_login_page(String username, String password) {
    sauceLoginPage.login(username,password);
    }
    @Then("User validates the {string} from SauceMainPage")
    public void user_validates_the_from_sauce_main_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }
}
