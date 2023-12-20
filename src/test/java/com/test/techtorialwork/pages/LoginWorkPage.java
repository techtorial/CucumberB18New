package com.test.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginWorkPage {

    public LoginWorkPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement loginButton;

    @FindBy(css = ".invalid-feedback")
    WebElement errorMessage;

    public void login(String username,String password){
        email.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public boolean isLoginVisible(){
        return loginButton.isDisplayed();
    }

    public void errorMessageAndColor(String expectedMessage,String expectedColor){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(errorMessage));
        Assert.assertEquals(expectedColor,errorMessage.getCssValue("color"));
    }

}
