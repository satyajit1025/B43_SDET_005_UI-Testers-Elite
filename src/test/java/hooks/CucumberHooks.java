package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportUtil;

public class CucumberHooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        if (!ExtentReportUtil.isReportInitialized()) {
            ExtentReportUtil.initReports();
        }
        ExtentReportUtil.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportUtil.logTestStep("Scenario failed: " + scenario.getName(), "fail");
        } else {
            ExtentReportUtil.logTestStep("Scenario passed: " + scenario.getName(), "pass");
        }
    }

    @After
    public void afterAllScenarios() {
        ExtentReportUtil.flushReports();
    }

}
