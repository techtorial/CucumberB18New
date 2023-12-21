package com.test.techtorialwork.stepdefinitions;

import com.test.techtorialwork.pages.MainWorkPage;
import com.test.techtorialwork.pages.ProductsWorkPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddProductStepDef {
    WebDriver driver= DriverHelper.getDriver();
    MainWorkPage mainWorkPage=new MainWorkPage(driver);
    ProductsWorkPage productsWorkPage=new ProductsWorkPage(driver);
    @When("User clicks Products Button on the left side and AddProductButton from ProductPage")
    public void user_clicks_products_button_on_the_left_side_and_add_product_button_from_product_page() {
    mainWorkPage.clickProductsButton();
    productsWorkPage.clickAddProductButton();
    }
    @When("User provides {string} and {string} to the product details boxes")
    public void user_provides_and_to_the_product_details_boxes(String productName, String price) {
    productsWorkPage.provideProductInformation(productName,price);
    }
    @When("User selects {string},{string},and {string} from drop-downs")
    public void user_selects_and_from_drop_downs(String category, String subCategory, String tax) {
    productsWorkPage.provideDropDownInformation(category,subCategory,tax);
    }
    @When("User clicks purchase check box and add {string} into the description")
    public void user_clicks_purchase_check_box_and_add_into_the_description(String description) {
    productsWorkPage.checkBoxAndDescription(description);
    }
    @When("User provides picture {string} and click save button")
    public void user_provides_picture_and_click_save_button(String location) throws InterruptedException {
    productsWorkPage.pictureAndSave(location);
    }
    @Then("User validates product details {string},{string},{string} from table")
    public void user_validates_product_details_from_table(String expectedProductName, String expectedPrice, String canPurchase) throws InterruptedException {
    productsWorkPage.allInformation(expectedProductName,expectedPrice,canPurchase);
    }
    @When("User clicks Products Button")
    public void user_clicks_products_button() {
    mainWorkPage.clickProductsButton();
    }
    @When("User selects {string} and {string} for categories")
    public void user_selects_and_for_categories(String category, String subcategory) {
    productsWorkPage.filterCategories(category,subcategory);
    }
    @When("User clicks three dots and view button from ProductPage")
    public void user_clicks_three_dots_and_view_button_from_product_page() {
    productsWorkPage.clickActionAndViewButton();
    }
    @Then("User validates {string} and {string} from action view")
    public void user_validates_and_from_action_view(String expectedCategory, String expectedSubCategory) {
    productsWorkPage.categoryInformation(expectedCategory,expectedSubCategory);
    }
}
