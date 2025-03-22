package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
    WebDriver driver;
    public AddtoCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//img[@class=\"product-image-photo\"])[3]")
    WebElement prod;

    @FindBy(xpath = "(//div[text()=\"M\"])[1]")
    WebElement size;

    @FindBy(id = "option-label-color-93-item-52")
    WebElement color;

    @FindBy(xpath = "//button[@id=\"product-addtocart-button\"]")
    WebElement addtocart;

    @FindBy(xpath = "//div[@role=\"alert\"]")
    WebElement success;

    @FindBy(className = "base")
    WebElement p_title;

    @FindBy(className = "minicart-wrapper")
    WebElement cart;

    @FindBy(xpath = "//span[text()=\"View and Edit Cart\"]")
    WebElement view_cart;

    @FindBy(xpath = "(//strong[@class=\"product-item-name\"])[2]")
    WebElement c_title;

    public void select_prod(){
        prod.click();
    }

    public void Size(){
        size.click();
    }

    public void Color(){
        color.click();
    }

    public void Add(){
        addtocart.click();
    }

    public boolean Success(){
        success.isDisplayed();
        return true;
    }

    public String P_Title(){
        return p_title.getText();
    }

    public void Cart(){
        cart.click();
    }

    public void  View_Cart(){
        view_cart.click();
    }

    public String C_Title(){
        return c_title.getText();
    }
}
