package com.swagLaps.utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {
    private Scrolling() {
    }
    @Step("Scrolling to element: {locator}")
    public static void scrollToElement(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to element: " , locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elementActions.findElement(driver,locator));

    }
}
