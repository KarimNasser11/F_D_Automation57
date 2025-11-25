package com.swagLaps.page;

import com.swagLaps.utilities.elementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class overviewPage {
    private final By finishButton=By.id("finish");
    private WebDriver driver;


//    constructor
    public overviewPage (WebDriver driver){
        this.driver=driver;
    }
@Step("Click Finish Button")
    public ConfirmationPage clickfinishbutton(){
        elementActions.clickonElement(driver,finishButton);
        return new ConfirmationPage(driver);
    }
    }

