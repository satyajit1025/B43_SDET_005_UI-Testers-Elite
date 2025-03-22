package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    WebDriver driver;
    public SignUp(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//a[text()=\"Create an Account\"])[1]")
    WebElement signupbtn;

    @FindBy(id = "firstname")
    WebElement fname;

    @FindBy(id = "lastname")
    WebElement lname;

    @FindBy(id = "email_address")
    WebElement email;

    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement pass;

    @FindBy(xpath = "//input[@id=\"password-confirmation\"]")
    WebElement cpass;

    @FindBy(xpath = "//button[@title=\"Create an Account\"]")
    WebElement button;

    @FindBy(xpath = "//div[text()=\"Thank you for registering with Main Website Store.\"]")
    WebElement success_msg;

    @FindBy(xpath = "//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
    WebElement error_msg;

    public void signUp(){
        signupbtn.click();
    }

    public void FirstName(String name, String  l_name, String Email, String password, String C_pass){
        fname.sendKeys(name);
        lname.sendKeys(l_name);
        email.sendKeys(Email);
        pass.sendKeys(password);
        cpass.sendKeys(C_pass);
    }

    public void btn(){
        button.click();
    }

    public boolean success(){
        success_msg.isDisplayed();
        return true;
    }

    public boolean error(){
        error_msg.isDisplayed();
        return true;
    }

}
