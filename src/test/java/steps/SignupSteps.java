package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.SignUp;

public class SignupSteps {
    WebDriver driver;
    SignUp signup;
    
    @Given("User in the homepage of the application")
    public void userInTheHomepageOfTheApplication() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        signup = new SignUp(driver);
    }

    @When("User click on create an account")
    public void userClickOnCreateAnAccount() {
        signup.signUp();
    }

    @Then("User redirected to the signup page and enter details")
    public void userRedirectedToTheSignupPageAndEnterDetails() {
        signup.FirstName("satya","sahu","satyaj9@gmail.com","Satya@123","Satya@123");
    }

    @And("Click on signup button")
    public void clickOnSignupButton() {
        signup.btn();
    }

    @Then("User should signup successfully")
    public void userShouldSignupSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String Actual_URl = driver.getCurrentUrl();
        String Expected_URL = "https://magento.softwaretestingboard.com/customer/account/";
        boolean msg = signup.success();
        SoftAssert ast = new SoftAssert();
        ast.assertEquals(Actual_URl,Expected_URL,"Not same");
        ast.assertTrue(msg);
        ast.assertAll();
        driver.quit();
    }
}
