package com.swagLaps.driver;

//import com.swagLaps.utilities.LogsUtils;
//import io.qameta.allure.Step;
import com.swagLaps.utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.FileAssert.fail;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private DriverManager() {
        super();
    }

    @Step("Creating browser instance: {browserName}")
    public static WebDriver createInstance(String browserName) {
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        LogsUtils.info("Creating browser instance: " + browserName);
        setDriver(driver);
        return getDriver();
    }



    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtils.error("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }
    public static void setDriver(WebDriver driver) {

        driverThreadLocal.set(driver);
    }
}
