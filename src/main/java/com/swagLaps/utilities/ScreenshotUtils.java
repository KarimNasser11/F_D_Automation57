package com.swagLaps.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.swagLaps.driver.DriverManager;
import java.io.File;

public class ScreenshotUtils {
    public static final String SCREENSHOTS_FOLDER = "test-output/screenshots";
    private ScreenshotUtils() {
    }
    public static void TakeScreenshot(String screenshotName){
try {
    if (DriverManager.getDriver() == null){
        LogsUtils.warn("Driver is null, cannot take screenshot: " + screenshotName);
        return;
    }

    File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    File ScreenshotFile = new File( SCREENSHOTS_FOLDER+ "/" +screenshotName + ".png");
    FileUtils.copyFile(screenshot, ScreenshotFile);
    allureUtils.attachScreenshotToAllureReport(screenshotName, ScreenshotFile.getPath());
}catch (Exception e){
    LogsUtils.error("Failed to take screenshot: " + e.getMessage());
    }
    }
}
