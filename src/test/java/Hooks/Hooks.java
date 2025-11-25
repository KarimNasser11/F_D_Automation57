package Hooks;

import com.swagLaps.driver.DriverManager;
import com.swagLaps.page.loginpage;
import com.swagLaps.utilities.FilesUtiles;
import com.swagLaps.utilities.JsonUtils;
import com.swagLaps.utilities.PropertiesUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Properties;

import static com.swagLaps.utilities.FilesUtiles.deleteFiles;

public class Hooks {
    WebDriver driver;
    public static JsonUtils testData;
    File allureResults = new File("test-output/allure-results");
    File logs = new File("test-output/Logs");
    File screenshots = new File("test-output/screenshots");
    @Before
    public void setup() {
        // 1️⃣ تحميل الـ properties
        PropertiesUtils.loadProperties();

        // 2️⃣ مسح الملفات القديمة
        if (allureResults.exists()) FilesUtiles.deleteFiles(allureResults);
        if (!logs.exists()) logs.mkdirs();
        FilesUtiles.cleanDirectory(logs);
        if (!screenshots.exists()) screenshots.mkdirs();
        FilesUtiles.cleanDirectory(screenshots);
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createInstance(browserName);
        new loginpage(driver).NavigateToLoginPage();
        testData = new JsonUtils("test-data");
    }
    @After
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
