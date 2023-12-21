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

    public void addProductFunctionality(String nameOfProduct,String price,String categoryOfProduct,
                                        String subCategoryOfProduct,String taxOfProduct, String description,String location){
        this.nameOfProduct.sendKeys(nameOfProduct);
        this.price.sendKeys(price);
        BrowserUtils.selectBy(this.categoryOfProduct,categoryOfProduct,"text");
        BrowserUtils.selectBy(this.subCategoryOfProduct,subCategoryOfProduct,"text");
        BrowserUtils.selectBy(this.taxOfProduct,taxOfProduct,"text");
        Assert.assertFalse(purchaseBox.isSelected());
        purchaseBox.click();
        Assert.assertTrue(purchaseBox.isSelected());
        this.description.sendKeys(description);
        chooseFile.sendKeys(location);
        saveButton.click();
    }




}
