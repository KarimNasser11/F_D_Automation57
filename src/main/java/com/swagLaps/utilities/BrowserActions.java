package com.swagLaps.utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
    }
    @Step("Navigating to URL: {url}")
    public static void NavigateToUrl(WebDriver driver, String url) {
        driver.get(url);
        LogsUtils.info("Navigated to URL: " + url);
    }
//    get current url
    @Step("Getting current URL")
    public static String getCurrentUrl(WebDriver driver) {
        LogsUtils.info("Getting current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
//    get page title
    @Step("Getting page title")
    public static String getPageTitle(WebDriver driver) {
        LogsUtils.info("Getting page title: " + driver.getTitle());
        return driver.getTitle();
    }
//    refresh page
    @Step("Refreshing the page")
    public static void refreshPage(WebDriver driver) {
        LogsUtils.info("Refreshing the page");
        driver.navigate().refresh();
    }

//    Close browser
    @Step("Closing the browser")
    public static void CloseBrowser(WebDriver driver) {
        LogsUtils.info("Closing the browser");
        driver.quit();
    }
}
