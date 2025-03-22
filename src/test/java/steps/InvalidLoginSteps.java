package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.Login;
import java.time.Duration;

public class InvalidLoginSteps {
    WebDriver driver;
    Login login;

    @Given("user on the homepage of the url")
    public void userOnTheHomepageOfTheUrl() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        login = new Login(driver);
    }

    @When("user click on on signIn")
    public void userClickOnOnSignIn() {
        login.sign();
    }

    @Then("user redirected to login page and enter details")
    public void userRedirectedToLoginPageAndEnterDetails() {
        login.userid("satya@gmail.com");
        login.password("Satya@1231");
    }

    @And("click on login")
    public void clickOnLogin() {
        login.login();
    }

    @Then("user shouldnot login")
    public void userShouldnotLogin() throws InterruptedException {
        Thread.sleep(2000);
        boolean message = login.msg();
        Assert.assertTrue(message);
        driver.quit();
    }
}
