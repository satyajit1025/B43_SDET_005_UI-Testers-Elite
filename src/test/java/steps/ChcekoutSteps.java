package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AddtoCart;
import pages.Checkout;
import pages.Login;

import java.time.Duration;

public class ChcekoutSteps {
    WebDriver driver;
    Checkout checkout;
    Login login;
    AddtoCart addtocart;

    @Given("User on the homepage of the URL")
    public void userOnTheHomepageOfTheURL() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        login = new Login(driver);
        checkout = new Checkout(driver);
        addtocart = new AddtoCart(driver);
    }

    @When("USer add a product to the cart")
    public void userAddAProductToTheCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addtocart.select_prod();
        addtocart.Size();
        addtocart.Color();
        addtocart.Add();
    }

    @Then("User checkout that product")
    public void userCheckoutThatProduct() throws InterruptedException {
        Thread.sleep(3000);
        addtocart.Cart();
        addtocart.View_Cart();
        checkout.CheckOut();
        checkout.Mail("satya45@gmail.com");
        Thread.sleep(2000);
        checkout.name("satya","sahu");
        checkout.Address("Odsiha","BBSR");
        checkout.State();
        checkout.ZipCode("12345");
        checkout.Country();
        checkout.Mobile("1234567990");
        checkout.Radio();
        checkout.Next();
    }

    @Then("User successfully purchase that product")
    public void userSuccessfullyPurchaseThatProduct() {
        checkout.Checkbox();
        checkout.place_Order();
        boolean message = checkout.msg();
        Assert.assertTrue(message);
        driver.quit();
    }
}
