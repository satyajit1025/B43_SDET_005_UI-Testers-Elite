package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wishlist {
    WebDriver driver;
    public Wishlist(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//img[@class=\"product-image-photo\"])[3]")
    WebElement prod;

    @FindBy(xpath = "(//span[text()=\"Add to Wish List\"])[1]")
    WebElement wishlist;

    @FindBy(xpath = "//div[@role=\"alert\"]")
    WebElement success;

    @FindBy(xpath = "(//a[@class=\"product-item-link\"])[1]")
    WebElement w_title;

    @FindBy(className = "base")
    WebElement p_title;

    public void Product(){
        prod.click();
    }

    public void WishList(){
        wishlist.click();
    }

    public boolean msg(){
        return success.isDisplayed();
    }

    public String P_Title(){
        return p_title.getText();
    }

    public  String W_Title(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class=\"product-item-link\"])[1]")));
        return w_title.getText();
    }
}
