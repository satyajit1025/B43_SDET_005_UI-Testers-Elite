package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.Login;

public class LoginSteps {
    WebDriver driver;
    Login login;

    @Given("User on the homepage of url")
    public void userOnTheHomepageOfUrl() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        login = new Login(driver);
    }

    @When("User click on SignIn")
    public void userClickOnSignIn() {
        login.sign();
    }

    @Then("User redirected to the Login page and enter details")
    public void userRedirectedToTheLoginPageAndEnterDetails() {
        login.userid("satya@gmail.com");
        login.password("Satya@123");
    }

    @And("Click on Login")
    public void clickOnLogin() {
        login.login();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String Actual = driver.getTitle();
        String Expect = "Home Page";
        boolean page = login.details();
        SoftAssert ast = new SoftAssert();
        ast.assertEquals(Actual,Expect,"Not same");
        ast.assertTrue(page);
        ast.assertAll();
        driver.quit();
    }
}
