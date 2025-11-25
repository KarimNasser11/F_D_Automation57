package StepsDefinition;

import Hooks.Hooks;
import com.swagLaps.driver.DriverManager;
import com.swagLaps.page.CartPage;
import com.swagLaps.page.HomePage;
import com.swagLaps.page.InformationPage;
import com.swagLaps.page.ConfirmationPage;
import com.swagLaps.page.loginpage;
import com.swagLaps.utilities.JsonUtils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {

    WebDriver driver = DriverManager.getDriver();
    loginpage login;
    HomePage homePage;
    CartPage cartPage;
    InformationPage infoPage;
    ConfirmationPage confirmationPage;
    JsonUtils testData = Hooks.testData;

    // ======= Background: Login + Home Page =======
    @Given("User is logged in and on Home Page")
    public void user_is_logged_in_and_on_home_page() {
        login = new loginpage(driver);
        login.enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton();
        homePage = new HomePage(driver).navigateTOHomePage();
    }

    // ======= Add Product =======
    @When("User adds first product to the cart for checkout")
    public void user_adds_first_product_to_the_cart_for_checkout() {
        String productName = testData.getJsonData("product-name.item1.name");
        homePage.addspicificProductTolocator(productName);
    }

    // ======= Go to Cart =======
    @And("User goes to the cart")
    public void user_goes_to_cart() {
        cartPage = homePage.clickoncatricon();
        String productName = testData.getJsonData("product-name.item1.name");
        String productPrice = testData.getJsonData("product-name.item1.price");
        cartPage.assertProductDetailes(productName, productPrice);
    }

    // ======= Proceed to Checkout =======
    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        infoPage = cartPage.ClickcheckoutButton();
    }

    // ======= Fill Information =======
    @And("User fills information")
    public void user_fills_information() {
        infoPage.FillInformationPage(
                testData.getJsonData("information-form.first-name"),
                testData.getJsonData("information-form.last-name"),
                testData.getJsonData("information-form.postal-code")
        );
    }

    @And("User continues to overview")
    public void user_continues_to_overview() {
        confirmationPage = infoPage.ClickContinueButtono().clickfinishbutton();
    }

    @Then("Order confirmation should be displayed")
    public void order_confirmation_should_be_displayed() {
        String expectedMessage = testData.getJsonData("ConfirmationMessage");
        confirmationPage.assertConfirmationMessage(expectedMessage);
    }
}
