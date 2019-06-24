package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

    private WebDriver ebaydriver;

    public Register(WebDriver ebaydriver){

        this.ebaydriver = ebaydriver;
        PageFactory.initElements(ebaydriver, this);
    }


    @FindBy(xpath = "//a[text()=\'register\']")
    public WebElement registerlink;

    @FindBy(name = "firstname")
    public WebElement firstnameField;

    @FindBy(name = "lastname")
    public WebElement lastnameField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "PASSWORD")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@id='ppaFormSbtBtn']")
    public WebElement registerButton;

    @FindBy(xpath = "//b[@class=\"gh-eb-arw gh-sprRetina\"]")
    public WebElement profileArrow;

    @FindBy(xpath = "//a[text()=\'Sign Out\']")
    public WebElement logoutLink;





}

