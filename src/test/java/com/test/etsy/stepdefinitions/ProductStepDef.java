package com.test.etsy.stepdefinitions;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Et;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class ProductStepDef {
    WebDriver driver= DriverHelper.getDriver();
    EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
       driver.get(url);
    }
    @When("User searches {string} for Etsy")
    public void user_searches_for_etsy(String search) {
       etsyMainPage.searchProduct(search);
    }
    @Then("User validates the title {string} from Etsy")
    public void user_validates_the_title_from_etsy(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }

    @When("User searches for Etsy")
    public void user_searches_for_etsy(DataTable dataTable) {
      Map<String,String> information=dataTable.asMap();
        etsyMainPage.searchProduct(information.get("productName"));
    }
    @Then("User validates the title from Etsy")
    public void user_validates_the_title_from_etsy(DataTable dataTable) {
        List<String> title=dataTable.asList();
        System.out.println(title.get(0));
        Assert.assertEquals(title.get(0),driver.getTitle().trim());
    }
}
