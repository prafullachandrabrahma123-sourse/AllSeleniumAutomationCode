package CucumberImplementation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/CucumberImplementation",
    glue = {"StepDefinations"},
    monochrome = true,tags ="@Regression",
    plugin = {"html:target/cucumber.html"})
public class TestNGTest_runner extends AbstractTestNGCucumberTests {
}
