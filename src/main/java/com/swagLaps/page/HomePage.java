package com.swagLaps.page;

import com.swagLaps.utilities.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage  {

    private final  WebDriver driver;
    private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage navigateTOHomePage(){
        BrowserActions.NavigateToUrl(driver, PropertiesUtils.getPropertyValue("homeURL"));
        return this;
    }
    @Step
    public HomePage addspicificProductTolocator(String productName){
        LogsUtils.info("Adding" + productName +"to cart");
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName +  "']"));
        elementActions.clickonElement(driver,addToCartButton);
        return this;
    }

//    validations

@Step("Click on the Cart ")
    public CartPage clickoncatricon(){
        elementActions.clickonElement(driver,cartIcon);
        return new  CartPage(driver);
    }
    @Step("Assert Product To Cart ")
    public HomePage assertProductAddTocart(String productName){
        By addToCartButton =RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName +  "']"));
        String ActualValue= elementActions.getText(driver,addToCartButton);
        LogsUtils.info("ActualValue "+ ActualValue);
        validations.ValidateEqual(ActualValue,"Remove","priduct not added to cart ");
        LogsUtils.info(productName+ "added To Cart successfully");
        return this;
    }






























}























