package StepsDefinition;

import Hooks.Hooks;
import com.swagLaps.driver.DriverManager;
import com.swagLaps.page.CartPage;
import com.swagLaps.page.HomePage;
import com.swagLaps.page.loginpage;
import com.swagLaps.utilities.JsonUtils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
public class AddProductSteps {
    WebDriver driver = DriverManager.getDriver();
    loginpage login;
    HomePage homePage;
    CartPage cartPage;
    JsonUtils testData = Hooks.testData; // استخدم الـ JsonUtils من Hooks

    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        login=new loginpage(DriverManager.getDriver());
        login.enterUsername(Hooks.testData.getJsonData("login-credentials.username"))
                .enterPassword(Hooks.testData.getJsonData("login-credentials.password"));
        login.clickLoginButton();
        homePage = new HomePage(driver).navigateTOHomePage();



    }

    @When("User adds first product to the cart")
    public void user_adds_first_product_to_the_cart() {
        String productName = testData.getJsonData("product-name.item1.name");
        homePage.addspicificProductTolocator(productName);
    }

    @When("User opens the cart")
    public void user_opens_the_cart() {
        cartPage = homePage.clickoncatricon();
    }

    @Then("The first product should appear in the cart")
    public void the_first_product_should_appear_in_the_cart() {
        String productName = testData.getJsonData("product-name.item1.name");
        String productPrice = testData.getJsonData("product-name.item1.price");
        cartPage.assertProductDetailes(productName, productPrice);
    }

}
