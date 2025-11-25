package com.swagLaps.page;

import com.swagLaps.utilities.BrowserActions;
import com.swagLaps.utilities.CustomSoftAssertion;
import com.swagLaps.utilities.elementActions;
import com.swagLaps.utilities.validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.swagLaps.utilities.PropertiesUtils.getPropertyValue;

public class loginpage {
//    variables
    private  final WebDriver driver;
//    Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");


//constructor
    public loginpage(WebDriver driver) {
        this.driver = driver;
    }

//    Actions
    @Step("Navigate to Login Page")
    public void NavigateToLoginPage() {
        BrowserActions.NavigateToUrl(driver,getPropertyValue("baseURL"));
    }
    @Step("Enter Username: {username}")
    public loginpage enterUsername(String username) {
        elementActions.sendData(driver,this.usernameField,username);
        return this;
    }
    @Step("Enter Password: {password}")
    public loginpage enterPassword(String password) {
        elementActions.sendData(driver,this.passwordField,password);
        return this;
    }
    @Step("Click on Login Button")
    public loginpage clickLoginButton() {
        elementActions.clickonElement(driver,this.loginButton);
        return this;
    }
    @Step("Get Error Message")
    public String geterrorMessage() {
        return elementActions.getText(driver, errorMessage);
    }

@Step("Assert Login Page URL")
public  loginpage assertLoginPageurl() {
    CustomSoftAssertion.SoftAssertion.assertEquals(BrowserActions.getCurrentUrl(driver),
            getPropertyValue("homeURL"),
            "Login page URL is incorrect");
    return this;
}

@Step("Assert Login Page Title")
public loginpage assertLoginPageTitle() {
    CustomSoftAssertion.SoftAssertion.assertEquals(BrowserActions.getPageTitle(driver),
            getPropertyValue("pageTittle"),
            "Login page title is incorrect");
    return this;
}
    @Step("Assert Successful Login with Soft Assertions")
    public loginpage assertsuccessfulLoginSoft() {
        assertLoginPageurl().assertLoginPageTitle();

        return this;

    }

//    @Step("Assert Successful Login by URL Validation")
//    public loginpage assertsuccessfulLogin() {
//        validations.ValidatePageURL(driver,"https://www.saucedemo.com/inventory.html");
//        return this;
//
//    }
@Step("Assert Successful Login by URL Validation")
public loginpage assertsuccessfulLogin() {
    validations.ValidatePageURL(driver,getPropertyValue("homeURL"));
    return this;

}
//    @Step("Assert Unsuccessful Login")
//    public loginpage assertUnsuccessfulLogin() {
//        validations.ValidateEqual(geterrorMessage(),
//                "Epic sadface: Username and password do not match any user in this service",
//                "Error message is incorrect");
//
//        return this;
//    }
@Step("Assert Unsuccessful Login")
public loginpage assertUnsuccessfulLogin() {
    validations.ValidateEqual(geterrorMessage(),
            getPropertyValue("errorMSG"),
            "Error message is incorrect");
    return this;
}

}
