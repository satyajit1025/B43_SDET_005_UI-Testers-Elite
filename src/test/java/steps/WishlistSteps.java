package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.Wishlist;

import java.time.Duration;

public class WishlistSteps {
    WebDriver driver;
    Wishlist wishlist;
    Login login;

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        login = new Login(driver);
        wishlist = new Wishlist(driver);
    }

    @When("User logged in to account")
    public void userLogged_inToAccount() {
        login.sign();
        login.userid("satya@gmail.com");
        login.password("Satya@123");
        login.login();
    }

    @And("Add a product to the wishlist")
    public void addAProductToTheWishlist() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wishlist.Product();
    }

    @Then("Product added successfully")
    public void productAddedSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String Actual = wishlist.P_Title();
        wishlist.WishList();
        String Expected = wishlist.W_Title();
        boolean message = wishlist.msg();
        SoftAssert ast = new SoftAssert();
        ast.assertTrue(message);
        ast.assertEquals(Actual, Expected);
        ast.assertAll();
        driver.quit();
    }
}
