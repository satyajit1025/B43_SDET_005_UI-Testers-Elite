package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SignUp;

public class InvalidSignupSteps {
    WebDriver driver;
    SignUp signup;
    @Given("user in the homepage of the application")
    public void userInTheHomepageOfTheApplication() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        signup = new SignUp(driver);
    }

    @When("user click on create an account")
    public void userClickOnCreateAnAccount() {
        signup.signUp();
    }

    @Then("user redirected to the signup page and enter duplicate details")
    public void userRedirectedToTheSignupPageAndEnterDuplicateDetails() {
        signup.FirstName("satya","sahu","satya@gmail.com","Satya@123","Satya@123");
    }

    @And("click on signup button")
    public void clickOnSignupButton() {
        signup.btn();
    }

    @Then("user should not able to signup")
    public void userShouldNotAbleToSignup() {
        boolean view = signup.error();
        Assert.assertTrue(view,"same mail id");
        driver.quit();
    }
}
