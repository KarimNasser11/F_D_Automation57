package com.swagLaps.page;

import com.swagLaps.utilities.CustomSoftAssertion;
import com.swagLaps.utilities.elementActions;
import com.swagLaps.utilities.validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final By producctName =By.cssSelector(".inventory_item_name");
    private final By producctPrice =By.cssSelector(".inventory_item_price");
    private final By checkoutButton =By.cssSelector(".checkout_button");
    private WebDriver driver;

    public CartPage (WebDriver driver){
        this.driver=driver;
    }


    public String getProductName(){
        return elementActions.getText(driver,producctName);
    }

    public String getProductPrice(){
        return elementActions.getText(driver,producctPrice);
    }



    public InformationPage  ClickcheckoutButton(){
        elementActions.clickonElement(driver,checkoutButton);
        return new InformationPage(driver);
    }
    @Step("Assert Product Details")

    public CartPage assertProductDetailes(String productName, String productPrice) {

        String actualProductName = getProductName();
        String actualProductPrice = getProductPrice();
        CustomSoftAssertion.SoftAssertion.assertEquals(actualProductName, productName, "Product Name mismatch");
        CustomSoftAssertion.SoftAssertion.assertEquals(actualProductPrice, productPrice, "Product Price mismatch");

        return this;
    }



}
