package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.ClientsWorkPage;
import com.test.techtorialwork.pages.MainWorkPage;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ClientsStepDef {
    WebDriver driver= DriverHelper.getDriver();
    MainWorkPage mainWorkPage=new MainWorkPage(driver);
    ClientsWorkPage clientsWorkPage=new ClientsWorkPage(driver);

    @When("User clicks Clients button")
    public void user_clicks_clients_button() {
    mainWorkPage.clickClientsButton();
    }
    @When("User clicks add client and provides {string}, {string},{string},{string} for ClientPage")
    public void user_clicks_add_client_and_provides_for_client_page(String name, String email, String country, String mobile) throws InterruptedException {
    clientsWorkPage.clientInformation(name,email,country,mobile);
    }
    @When("User provides company information {string},{string},{string}")
    public void user_provides_company_information(String companyName, String companyWebsite, String officePhone) throws InterruptedException {
    clientsWorkPage.companyInformation(companyName,companyWebsite,officePhone);
    }
    @When("User provides address information {string},{string}")
    public void user_provides_address_information(String companyAddress, String shippingAddress) throws InterruptedException {
    clientsWorkPage.addressInformation(companyAddress,shippingAddress);
    }

    @Then("User clicks save button and validates {string},{string},{string},{string} from table.")
    public void user_clicks_save_button_and_validates_from_table(String expectedName, String expectedCompanyName,
                                                                 String expectedEmail, String expectedStatus) throws InterruptedException {
    clientsWorkPage.saveAndValidate(expectedName,expectedCompanyName,expectedEmail,expectedStatus);
    }
}
