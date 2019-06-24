package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    private WebDriver ebaydriver;

    public Login(WebDriver ebaydriver){

        this.ebaydriver = ebaydriver;
        PageFactory.initElements(ebaydriver, this);
    }

    @FindBy(xpath = "//span[@id=\"GREET-SIGN-IN-TO-EBAY\"")
    public WebElement LogInlink;

    @FindBy(id = "userid")
    public WebElement usernameField;

    @FindBy(xpath = "//a[text()=\'Sign in\']")
    public WebElement SignInlink;

    @FindBy(xpath = "//a[text()=\' My eBay\']")
    public WebElement myEbaylink;

    @FindBy(xpath = "//a[@class=\"mbg-id\"]")
    public WebElement ebayID;

    @FindBy(id = "pass")
    public WebElement pwordField;

    @FindBy(xpath = "//button[@id=\'sgnBt\']")
    public WebElement signInButton;



}
