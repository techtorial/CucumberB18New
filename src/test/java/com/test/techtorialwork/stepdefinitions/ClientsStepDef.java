package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.ClientsWorkPage;
import com.test.techtorialwork.pages.MainWorkPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class ClientsStepDef {
    WebDriver driver = DriverHelper.getDriver();
    MainWorkPage mainWorkPage = new MainWorkPage(driver);
    ClientsWorkPage clientsWorkPage = new ClientsWorkPage(driver);

    @When("User clicks Clients button")
    public void user_clicks_clients_button() {
        mainWorkPage.clickClientsButton();
    }

    @When("User clicks add client and provides {string}, {string},{string},{string} for ClientPage")
    public void user_clicks_add_client_and_provides_for_client_page(String name, String email, String country, String mobile) throws InterruptedException {
        clientsWorkPage.clientInformation(name, email, country, mobile);
    }

    @When("User provides company information {string},{string},{string}")
    public void user_provides_company_information(String companyName, String companyWebsite, String officePhone) throws InterruptedException {
        clientsWorkPage.companyInformation(companyName, companyWebsite, officePhone);
    }

    @When("User provides address information {string},{string}")
    public void user_provides_address_information(String companyAddress, String shippingAddress) throws InterruptedException {
        clientsWorkPage.addressInformation(companyAddress, shippingAddress);
    }

    @Then("User clicks save button and validates {string},{string},{string},{string} from table.")
    public void user_clicks_save_button_and_validates_from_table(String expectedName, String expectedCompanyName,
                                                                 String expectedEmail, String expectedStatus) throws InterruptedException {
        clientsWorkPage.saveAndValidate(expectedName, expectedCompanyName, expectedEmail, expectedStatus);
    }

    @When("User clicks add client and provides personal information")
    public void user_clicks_add_client_and_provides_personal_information(DataTable dataTable) throws InterruptedException {
        Map<String, String> allPersonalInformation = dataTable.asMap();
        clientsWorkPage.clientInformation(allPersonalInformation.get("name"),
                allPersonalInformation.get("email"),
                allPersonalInformation.get("country"),
                allPersonalInformation.get("mobile"));
    }

    @When("User provides company information")
    public void user_provides_company_information(DataTable dataTable) throws InterruptedException {
        Map<String, String> allCompanyInformation = dataTable.asMap();
        clientsWorkPage.companyInformation(allCompanyInformation.get("companyName"),
                allCompanyInformation.get("companyWebsite"),
                allCompanyInformation.get("companyPhone"));
    }

    @When("User provides address information")
    public void user_provides_address_information(DataTable dataTable) throws InterruptedException {
        List<String> allAddressInformation = dataTable.asList();
        clientsWorkPage.addressInformation(allAddressInformation.get(0),
                allAddressInformation.get(1));
    }

    @Then("User clicks save button and validates information")
    public void user_clicks_save_button_and_validates_information(DataTable dataTable) throws InterruptedException {
        List<String> allClientInformation = dataTable.asList();
        clientsWorkPage.saveAndValidate(allClientInformation.get(0),
                allClientInformation.get(1),
                allClientInformation.get(2),
                allClientInformation.get(3));
    }
}
