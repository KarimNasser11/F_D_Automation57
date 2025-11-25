package com.swagLaps.utilities;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class allureUtils {
    public static final String ALLURE_Results_PATH="test-output/allure-results";
    private allureUtils() {
    }
    public static void attachLogToAllureReport() {
        try {
            File logFile = FilesUtiles.getLatestFile(LogsUtils.logs_Path);
            if (!logFile.exists()) {
                LogsUtils.warn("Log file does not exist: " + LogsUtils.logs_Path);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
        }catch (Exception e){
            LogsUtils.error("Failed to attach log to Allure report: " + e.getMessage());

        }
        }

        public static void attachScreenshotToAllureReport(String screenshotName, String screenshoPath){
        try {
            Allure.addAttachment(screenshotName,Files.newInputStream(Path.of(screenshoPath)));

        }catch (Exception e){
//            LogsUtils.error("");
            LogsUtils.error("Failed To attach screenshot to allure report"+ e.getMessage());
        }

        }

        // Implementation to attach log to Allure report

}
