package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"StepsDefinition","Hooks"},
        plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",  // Allure plugin
        "html:target/cucumber-html-report"
}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
