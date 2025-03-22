package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;

public class Search {
    WebDriver driver;
    public Search(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "search")
    WebElement search_box;

    @FindBy(className = "product-item-link")
    List<WebElement> item;

    @FindBy(className = "columns")
    WebElement product;

    public void Searchp(String data){
        search_box.sendKeys(data);
        search_box.sendKeys(Keys.ENTER);
    }

    public void check(){
        for(WebElement allitems:item){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String text = allitems.getText();
            if(text.contains("Pant")){
                System.out.println("Expected data visible");
            }else{
                System.out.println("Not matched");
            }
        }
    }

    public boolean p_view(){
        product.isDisplayed();
        return true;
    }
}
