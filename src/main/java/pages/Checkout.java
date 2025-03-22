package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    WebDriver driver;
    public Checkout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()=\"Proceed to Checkout\"]")
    WebElement checkout;

    @FindBy(xpath = "(//input[@id=\"customer-email\"])[1]")
    WebElement mail;

    @FindBy(xpath = "(//input[@class=\"input-text\"])[4]")
    WebElement f_name;

    @FindBy(xpath = "(//input[@class=\"input-text\"])[5]")
    WebElement l_name;

    @FindBy(xpath = "(//input[@class=\"input-text\"])[7]")
    WebElement address;

    @FindBy(xpath = "(//input[@class=\"input-text\"])[10]")
    WebElement city;

    @FindBy(xpath = "(//select[@class=\"select\"])[1]")
    WebElement state;

    @FindBy(xpath = "(//input[@class=\"input-text\"])[12]")
    WebElement zipcode;

    @FindBy(xpath = "(//select[@class=\"select\"])[2]")
    WebElement country;

    @FindBy(xpath = "(//input[@class=\"input-text\"])[13]")
    WebElement mobile;

    @FindBy(xpath = "(//input[@class=\"radio\"])[1]")
    WebElement radio;

    @FindBy(xpath = "//span[text()=\"Next\"]")
    WebElement next;

    @FindBy(xpath = "(//input[@type=\"checkbox\"])[1]")
    WebElement checkBox;

    @FindBy(xpath = "//span[text()=\"Place Order\"]")
    WebElement place_order;

    @FindBy(className = "base")
    WebElement success;

    public void CheckOut(){
        checkout.click();
    }

    public void Mail(String email){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id=\"customer-email\"])[1]")));
        mail.sendKeys(email);
    }

    public void name(String fname, String lname){
        f_name.sendKeys(fname);
        l_name.sendKeys(lname);
    }

    public void Address(String add, String City){
        address.sendKeys(add);
        city.sendKeys(City);
    }

    public void State(){
        Select sel = new Select(state);
        sel.selectByVisibleText("Alabama");
    }

    public void ZipCode(String code){
        zipcode.sendKeys(code);
    }

    public void Country(){
        Select sel = new Select(country);
        sel.selectByVisibleText("United States");
    }

    public void Mobile(String num){
        mobile.sendKeys(num);
    }

    public void Radio(){
        radio.click();
    }

    public void Next(){
        next.click();
    }

    public void Checkbox(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"checkbox\"])[1]")));
        checkBox.click();
    }

    public void place_Order(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Place Order\"]")));
        place_order.click();
    }

    public boolean msg(){
        return success.isDisplayed();
    }
}
