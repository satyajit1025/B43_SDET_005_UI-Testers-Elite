package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.Wishlist;
import java.time.Duration;

public class InvalidWishlistSteps {
    WebDriver driver;
    Wishlist wishlist;

    @Given("user is on the homepage")
    public void userIsOnTheHomepage() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        wishlist = new Wishlist(driver);
    }

    @When("user click on a product")
    public void userClickOnAProduct() {
        wishlist.Product();
    }

    @And("user add to wishlist the product")
    public void userAddToWishlistTheProduct() {
        wishlist.WishList();
    }

    @Then("user not able to add to the wishlist")
    public void userNotAbleToAddToTheWishlist() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean error = wishlist.msg();
        String Actual = driver.getTitle();
        String Expected = "Customer Login";
        SoftAssert ast = new SoftAssert();
        ast.assertEquals(Actual,Expected);
        ast.assertTrue(error);
        ast.assertAll();
        driver.quit();
    }
}
