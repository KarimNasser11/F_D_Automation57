package com.swagLaps.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waites {
    private Waites() {
    }
//    lambda xpressions
//    present - visible - clickable
    public static WebElement waitforelementpresent(WebDriver driver, By locator) {
        LogsUtils.info("Waiting for element present: " , locator.toString());
       return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                      driver1.findElement(locator));


    }
    public static WebElement waitforelementvisible(WebDriver driver, By locator) {
        LogsUtils.info("Waiting for element visible: " , locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(  driver1 ->
                {
                    WebElement element =waitforelementpresent(driver, locator);
                    return element.isDisplayed() ? element : null;
                });

    }
    public static WebElement waitforelementclickable(WebDriver driver, By locator) {
        LogsUtils.info("Waiting for element clickable: " , locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(  driver1 ->
                {
                    WebElement element =waitforelementvisible(driver, locator);
                    return element.isEnabled() ? element : null;
                });

    }
}
