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
    @FindBy(xpath = "//select[@id='category_id']")
    WebElement category;
    @FindBy(xpath = "//select[@id='sub_category']")
    WebElement sub_category;
    @FindBy(xpath = "//a[contains(@id,'dropdownMenuLink')]")
    List<WebElement> actionButtons;
    @FindBy(xpath = "//a[.='View']")
    List<WebElement> viewButtons;
    @FindBy(xpath = "//p[contains(text(),'Lifting')]")
    WebElement productName;
    @FindBy(xpath = "//p[contains(text(),'Mobile')]")
    WebElement subCategory;

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

    public void filterCategories(String category,String subCategory){
        BrowserUtils.selectBy(this.category,category,"text");
        BrowserUtils.selectBy(this.sub_category,subCategory,"text");
    }

    public void clickActionAndViewButton(){
        actionButtons.get(0).click();
        viewButtons.get(0).click();
    }

    public void categoryInformation(String expectedCategory,String expectedSubCategory){
        Assert.assertEquals(expectedCategory,BrowserUtils.getText(productName));
        Assert.assertEquals(expectedSubCategory,BrowserUtils.getText(subCategory));
    }



}
