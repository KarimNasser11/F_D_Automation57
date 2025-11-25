package com.swagLaps.utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class validations {
//    Constructor private
private validations() {}


//Hard Assertion//
//Validation Methods
    @Step("Validating that condition is true")
    public static void ValidateTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step("Validating that condition is false")
    public static void ValidateFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
//    @Step("Validating that actual value equals expected value")
    public static void ValidateEqual(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
    @Step("Validating that actual value does not equal expected value")
    public static void ValidatenotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }


    @Step("Validating page URL equals expected URL")
    public static void ValidatePageURL(WebDriver driver, String expected) {
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expected);
    }

    @Step("Validating page title equals expected title")
    public static void ValidatePageTitle(WebDriver driver, String expected) {
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected   );
    }

}
