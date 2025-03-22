package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.Search;
import java.time.Duration;

public class SearchSteps {
    WebDriver driver;
    Search search;
    Login login;

    @Given("User on the homepage")
    public void userOnTheHomepage() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        search = new Search(driver);
        login = new Login(driver);
    }

    @When("User login to account")
    public void userLoginToAccount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login.sign();
        login.userid("satya@gmail.com");
        login.password("Satya@123");
        login.login();
    }

    @Then("User click on search and search a product")
    public void userClickOnSearchAndSearchAProduct() throws InterruptedException {
        Thread.sleep(2000);
        search.Searchp("pant");
    }

    @Then("User get data as per search")
    public void userGetDataAsPerSearch() {
        search.check();
        String Actual = driver.getCurrentUrl();
        String Expected = "https://magento.softwaretestingboard.com/catalogsearch/result/?q=pant";
        boolean p_list = search.p_view();
        SoftAssert ast = new SoftAssert();
        ast.assertEquals(Actual, Expected);
        ast.assertTrue(p_list);
        ast.assertAll();
        driver.quit();
    }
}
