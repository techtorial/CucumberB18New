package com.test.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProductsWorkPage {

    public ProductsWorkPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='table-actions']//a")
    WebElement addProductButton;
    @FindBy(css = "#name")
    WebElement nameOfProduct;
    @FindBy(css = "#price")
    WebElement price;
    @FindBy(xpath = "//select[@id='product_category_id']")
    WebElement categoryOfProduct;
    @FindBy(xpath = "//select[@id='sub_category_id']")
    WebElement subCategoryOfProduct;
    @FindBy(xpath = "//select[@id='tax_id']")
    WebElement taxOfProduct;
    @FindBy(xpath = "//input[@id='purchase_allow']")
    WebElement purchaseBox;
    @FindBy(css = "#description-text")
    WebElement description;
    @FindBy(xpath = "//button[.='Choose a file']")
    WebElement chooseFile;
    @FindBy(xpath = "//button[@id='save-product']")
    WebElement saveButton;

    public void pictureAndSave(String location){
        chooseFile.sendKeys(location);
        saveButton.click();
    }
    public void clickAddProductButton(){
        addProductButton.click();
    }
    public void provideProductInformation(String productName,String price){
        this.nameOfProduct.sendKeys(productName);
        this.price.sendKeys(price);
    }

    public void provideDropDownInformation(String category,String subCategory,String tax){
        BrowserUtils.selectBy(this.categoryOfProduct,category,"text");
        BrowserUtils.selectBy(this.subCategoryOfProduct,subCategory,"text");
        BrowserUtils.selectBy(this.taxOfProduct,tax,"value");
    }
    public void checkBoxAndDescription(String description){
        Assert.assertFalse(purchaseBox.isSelected());
        purchaseBox.click();
        Assert.assertTrue(purchaseBox.isSelected());
        this.description.sendKeys(description);
    }




}
