package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.LoginWorkPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginWorkStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginWorkPage loginWorkPage=new LoginWorkPage(driver);

    @Given("User validates the title is {string} from LoginPage")
    public void user_validates_the_title_is_from_login_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @Given("User validates the log_in is visible on the page")
    public void user_validates_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(loginWorkPage.isLoginVisible());
    }
    @When("User provides username and password to the loginPage")
    public void user_provides_username_and_password_to_the_login_page() {
        loginWorkPage.login(ConfigReader.readProperty("work_username"),
                            ConfigReader.readProperty("work_password"));
    }
    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }

    @When("User provides {string} and {string} to the loginPage")
    public void user_provides_and_to_the_login_page(String username, String password) {
        loginWorkPage.login(username,password);
    }
    @Then("User validates {string} and {string} from loginPage")
    public void user_validates_and_from_login_page(String errorMessage, String expectedColor) {
      loginWorkPage.errorMessageAndColor(errorMessage,expectedColor);
    }
}
