package com.swagLaps.page;

import com.swagLaps.utilities.elementActions;
import com.swagLaps.utilities.validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private final By confirmationpage=By.cssSelector(".complete-header");
    private WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    @Step("Get Information Message")
    public String getconformationMessage(){
        return elementActions.getText(driver,confirmationpage);
    }
    @Step("Assert Confirmation Message : {0}")
    public void assertConfirmationMessage(String ExpectedMessage){
        String actualMessage = getconformationMessage();
        validations.ValidateEqual(actualMessage,ExpectedMessage,"Confirmation Message mismatch");
    }
}
