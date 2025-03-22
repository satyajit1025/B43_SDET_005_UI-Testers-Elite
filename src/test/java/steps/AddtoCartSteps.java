package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.AddtoCart;
import pages.Login;
import java.time.Duration;

public class AddtoCartSteps {
    WebDriver driver;
    AddtoCart addtocart;
    Login login;
    @Given("User on the Homepage")
    public void userOnTheHomepage() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        addtocart = new AddtoCart(driver);
        login = new Login(driver);
    }

    @When("User login to the account")
    public void userLoginToTheAccount() {
        login.sign();
        login.userid("satya@gmail.com");
        login.password("Satya@123");
        login.login();
    }

    @And("User add a product to the cart")
    public void userAddAProductToTheCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addtocart.select_prod();
        addtocart.Size();
        addtocart.Color();
        addtocart.Add();
    }

    @Then("Product added to the cart successfully")
    public void productAddedToTheCartSuccessfully() throws InterruptedException {
        boolean msg = addtocart.Success();
        String Actual = addtocart.P_Title();
        addtocart.Cart();
        addtocart.View_Cart();
        Thread.sleep(2000);
        String Expected = addtocart.C_Title();
        SoftAssert ast = new SoftAssert();
        ast.assertTrue(msg);
        ast.assertEquals(Actual, Expected);
        ast.assertAll();
        driver.quit();
    }
}
