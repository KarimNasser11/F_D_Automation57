package com.swagLaps.utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementActions {
    private elementActions() {
    }
    @Step("Sending data to element: {locator} Data: {data}")
    public static void sendData(WebDriver driver, By locator, String data) {
        Waites.waitforelementvisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).sendKeys(data);
        LogsUtils.info("Data sent to element: " + data + " in the field: " ,locator.toString());
    }

    @Step("Clicking on the element: {locator}")
    public static void clickonElement(WebDriver driver, By locator) {
        Waites.waitforelementclickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).click();
        LogsUtils.info("Data sent to element: ", locator.toString());

    }

//get error message text
    @Step("Gettin the text from the element :{locator}")
    public static String getText(WebDriver driver, By locator) {
        Waites.waitforelementvisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtils.info("Get text from element: ",locator.toString()," Text: " + findElement(driver,locator).getText());
        return findElement(driver,locator).getText();
    }
    public static WebElement findElement(WebDriver driver, By locator) {
        LogsUtils.info("Finding element: " + locator.toString());
        return driver.findElement(locator);
    }
    public static String getTextFormInput(WebDriver driver, By locator){
        Waites.waitforelementvisible(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        LogsUtils.info("Getting Text From the Input Field: ", locator.toString(),"Text ",findElement(driver,locator).getDomAttribute("value"));
        return findElement(driver,locator).getDomAttribute("value");


    }
}
