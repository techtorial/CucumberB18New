package com.test.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

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
    @FindBy(xpath = "//tr[1]//td")
    List<WebElement> alLData;

    public void pictureAndSave(String location) throws InterruptedException {
        chooseFile.sendKeys(location);
        saveButton.click();
    }
    public void clickAddProductButton(){
        addProductButton.click();
    }
    public void provideProductInformation(String productName,String price){
        this.nameOfProduct.sendKeys(productName);
        this.price.clear();
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

    public void allInformation(String productName,String price,String canPurchase) throws InterruptedException {
        Thread.sleep(2000);
        List<String> expectedInformation= Arrays.asList("","","",productName,price,canPurchase,"");
        for(int i=3;i<alLData.size()-1;i++){
            Assert.assertEquals(expectedInformation.get(i),BrowserUtils.getText(alLData.get(i)));
        }
    }



}
