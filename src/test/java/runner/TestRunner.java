package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","hooks"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html"
        },
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
