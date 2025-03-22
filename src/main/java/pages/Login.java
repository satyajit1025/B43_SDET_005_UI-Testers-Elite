package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Sign In")
    WebElement signin_btn;

    @FindBy(id = "email")
    WebElement mail;

    @FindBy(xpath = "(//input[@id=\"pass\"])[1]")
    WebElement Pass;

    @FindBy(xpath = "(//button[@id=\"send2\"])[1]")
    WebElement login_btn;

    @FindBy(className = "page-wrapper")
    WebElement account;

    @FindBy(xpath = "//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
    WebElement error;

    public void sign(){
        signin_btn.click();
    }

    public void userid(String name){
        mail.sendKeys(name);
    }

    public void password(String pass){
        Pass.sendKeys(pass);
    }

    public void login(){
        login_btn.click();
    }

    public boolean details(){
        account.isDisplayed();
        return true;
    }

    public boolean msg(){
        error.isDisplayed();
        return true;
    }
}
