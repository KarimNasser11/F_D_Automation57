package com.swagLaps.listeners;

import com.swagLaps.utilities.*;
import org.testng.*;

import java.io.File;

import static com.swagLaps.utilities.PropertiesUtils.loadProperties;

public class TestNGListeners implements IExecutionListener, IInvokedMethodListener, ITestListener {
    File allure_Results = new File("test-output/allure-results");
    File logs = new File("test-output/Logs");
    File screenshoots = new File("test-output/screenshots");


    @Override
    public void onExecutionStart(){
        LogsUtils.info("Test Exection Started");
        loadProperties();
        FilesUtiles.deleteFiles(allure_Results);
        FilesUtiles.cleanDirectory(logs);
        FilesUtiles.cleanDirectory(screenshoots);

    }
    @Override
    public void onExecutionFinish(){
        LogsUtils.info("Test Exection Finished");
    }
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()){
            try
            {
                CustomSoftAssertion.CustomassertAll();

            } catch (AssertionError e) {

                testResult.setStatus(ITestResult.FAILURE);
                testResult.setThrowable(e);
            }
            switch (testResult.getStatus()){
                case ITestResult.SUCCESS -> ScreenshotUtils.TakeScreenshot("passed"+ testResult.getName());
                case ITestResult.FAILURE -> ScreenshotUtils.TakeScreenshot("Failure"+ testResult.getName());
                case ITestResult.SKIP -> ScreenshotUtils.TakeScreenshot("Skip"+ testResult.getName());

            }

            allureUtils.attachLogToAllureReport();
        }
    }
    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test Case"+result.getName() ,"passed");
    }

    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test Case"+result.getName() ,"Failed");
    }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test Case"+result.getName() ,"Skipped");
    }

}
