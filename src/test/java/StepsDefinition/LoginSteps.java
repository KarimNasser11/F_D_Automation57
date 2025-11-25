package StepsDefinition;

import Hooks.Hooks;
import com.swagLaps.driver.DriverManager;
import com.swagLaps.page.loginpage;
import com.swagLaps.utilities.JsonUtils;
import io.cucumber.java.en.*;
import static com.swagLaps.utilities.PropertiesUtils.getPropertyValue;

public class LoginSteps {

    private loginpage login;
    JsonUtils testData;


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        login = new loginpage(DriverManager.getDriver());
        login.NavigateToLoginPage();
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        login.enterUsername(Hooks.testData.getJsonData("login-credentials.username"))
                .enterPassword(Hooks.testData.getJsonData("login-credentials.password"));
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        login.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        login.assertsuccessfulLogin();
    }
}