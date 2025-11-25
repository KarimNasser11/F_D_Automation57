package com.swagLaps.page;

import com.swagLaps.utilities.CustomSoftAssertion;
import com.swagLaps.utilities.elementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {
    private WebDriver driver;
    private final By FirstName = By.id("first-name");
    private final By LastName = By.id("last-name");
    private final By Postal_Code = By.id("postal-code");
    private final By Continue = By.id("continue");





//    CONSTRUCTOR
    public InformationPage (WebDriver driver){
        this.driver=driver;
    }
    @Step("Fill Information Form : First Name: {0}, Last Name: {1}, Postal_code : {}")
    public InformationPage FillInformationPage(String firstName, String lastName, String postal_code){
        elementActions.sendData(driver,this.FirstName,firstName);
        elementActions.sendData(driver,this.LastName,lastName);
        elementActions.sendData(driver,this.Postal_Code,postal_code);
        return this;


    }
    @Step("Click Continue Button")
    public overviewPage ClickContinueButtono(){
        elementActions.clickonElement(driver,Continue);
        return new overviewPage(driver);
    }
    public void assertInformationPage(String firstName,String lastName ,String postal_Code){
        CustomSoftAssertion.SoftAssertion.assertEquals(elementActions.getTextFormInput(driver,this.FirstName),firstName);
        CustomSoftAssertion.SoftAssertion.assertEquals(elementActions.getTextFormInput(driver,this.LastName),lastName);
        CustomSoftAssertion.SoftAssertion.assertEquals(elementActions.getTextFormInput(driver,this.Postal_Code),postal_Code);
    }









}
