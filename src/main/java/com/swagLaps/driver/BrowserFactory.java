package com.swagLaps.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions Options = new ChromeOptions();
                Options.addArguments("--start-maximized");
                Options.addArguments("--disable-notifications");
                Options.addArguments("--incognito");
                Options.addArguments("--disable-popup-blocking");
                Options.addArguments("--disable-infobars");
                Options.addArguments("--disable-extensions");
//                Options.addArguments("--headless");
                Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                Map<String, Object> prefs = Map.of(
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autoFill.profile_enabled", false
                );
                Options.setExperimentalOption("prefs", prefs);
                return new ChromeDriver(Options);
//firefox
            case "firefox":
                FirefoxOptions FireOptions = new FirefoxOptions();
                FireOptions.addArguments("--start-maximized");
                FireOptions.addArguments("--disable-notifications");
                FireOptions.addArguments("--incognito");
                FireOptions.addArguments("--disable-popup-blocking");
                FireOptions.addArguments("--disable-infobars");
                FireOptions.addArguments("--disable-extensions");
                FireOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                FireOptions.setAcceptInsecureCerts(true);
//                Options.addArguments("--headless");
                return new FirefoxDriver(FireOptions);

//                EDGE BROWSER
            default:
                EdgeOptions edgeoptions = new EdgeOptions();
                edgeoptions.addArguments("--start-maximized");
                edgeoptions.addArguments("--disable-notifications");
                edgeoptions.addArguments("--incognito");
                edgeoptions.addArguments("--disable-popup-blocking");
                edgeoptions.addArguments("--disable-infobars");
                edgeoptions.addArguments("--disable-extensions");
//                Options.addArguments("--headless");
                Map<String, Object> edgeprefs = Map.of(
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autoFill.profile_enabled", false
                );
                edgeoptions.setExperimentalOption("prefs", edgeprefs);
                edgeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new EdgeDriver(edgeoptions);

        }
    }


}
