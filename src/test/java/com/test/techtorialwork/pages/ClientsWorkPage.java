package com.test.techtorialwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ClientsWorkPage {

    public ClientsWorkPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@class,'btn-primary rounded')]")
    WebElement addClientButton;
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#email")
    WebElement email;
    @FindBy(xpath = "//select[@id='country']")
    WebElement country;
    @FindBy(css = "#mobile")
    WebElement phoneNumber;
    @FindBy(css = "#company_name")
    WebElement companyName;
    @FindBy(css = "#website")
    WebElement website;
    @FindBy(css = "#office")
    WebElement officePhoneNumber;
    @FindBy(css = "#address")
    WebElement companyAddress;
    @FindBy(css = "#shipping_address")
    WebElement companyShippingAddress;
    @FindBy(xpath = "//button[@id='save-client-form']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@class='media-body']")
    List<WebElement> allNamesAndCompany;

    public void clientInformation(String name,String email,String country,String mobile) throws InterruptedException {
        addClientButton.click();
        Thread.sleep(1000);
        this.name.sendKeys(name);
        Thread.sleep(1000);
        this.email.sendKeys(email);
        Thread.sleep(1000);
        BrowserUtils.selectBy(this.country,country,"text");
        Thread.sleep(1000);
        phoneNumber.sendKeys(mobile);
        Thread.sleep(1000);
    }
    public void companyInformation(String companyName,String companyWebsite,String officePhone) throws InterruptedException {
        this.companyName.sendKeys(companyName);
        Thread.sleep(1000);
        this.website.sendKeys(companyWebsite);
        Thread.sleep(1000);
        this.officePhoneNumber.sendKeys(officePhone);
        Thread.sleep(1000);
    }

    public void addressInformation(String address,String shippingAddress) throws InterruptedException {
        this.companyAddress.sendKeys(address);
        Thread.sleep(1000);
        this.companyShippingAddress.sendKeys(shippingAddress);
        Thread.sleep(1000);
    }
    public void saveAndValidate(String expectedClientName,String expectedCompanyName,
                                String expectedEmail,String expectedStatus) throws InterruptedException {
        saveButton.click();
        Thread.sleep(1000);
    }



}
