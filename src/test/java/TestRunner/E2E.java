package TestRunner;
import com.swagLaps.driver.DriverManager;
import com.swagLaps.listeners.TestNGListeners;
import com.swagLaps.page.CartPage;
import com.swagLaps.page.HomePage;
import com.swagLaps.page.InformationPage;
import com.swagLaps.page.loginpage;
import com.swagLaps.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(TestNGListeners.class)
public class E2E {
    WebDriver driver;

    JsonUtils testData;
    @Test
    public void successfulLoginTest() {
        new loginpage(driver)
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertsuccessfulLogin();

//    .assertsuccessfulLoginSoft();
    }
    @Test(dependsOnMethods = "successfulLoginTest")
    public void AddingprductTocart(){
        new HomePage(driver).addspicificProductTolocator(testData.getJsonData("product-name.item1.name"))
                .assertProductAddTocart(testData.getJsonData("product-name.item1.name"));

    }
    @Test(dependsOnMethods = "AddingprductTocart")
    public void checkoutProduct(){
        new HomePage(driver).clickoncatricon().assertProductDetailes(testData.getJsonData("product-name.item1.name"),testData.getJsonData("product-name.item1.price"));
    }


    @Test(dependsOnMethods="checkoutProduct")
    public void FillInformationForm(){
        new CartPage(driver).ClickcheckoutButton().FillInformationPage(testData.getJsonData("information-form.first-name")
                ,testData.getJsonData("information-form.last-name"),
                testData.getJsonData("information-form.postal-code"))
                .assertInformationPage(testData.getJsonData("information-form.first-name"),
                testData.getJsonData("information-form.last-name"),
                        testData.getJsonData("information-form.postal-code"));
    }


    @Test(dependsOnMethods = "FillInformationForm")
    public void finishCheckout(){
        new InformationPage(driver).ClickContinueButtono().clickfinishbutton().assertConfirmationMessage(testData.getJsonData("ConfirmationMessage"));
    }



    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        testData = new JsonUtils("test-data");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver=  DriverManager.createInstance(browserName);
        new loginpage(driver).NavigateToLoginPage();
    }

    @AfterClass
    public void teardown() {
        BrowserActions.CloseBrowser(driver);

    }

}
