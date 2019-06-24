package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    private WebDriver shopping;

    public Checkout(WebDriver shopping){

        this.shopping = shopping;
        PageFactory.initElements(shopping, this);

    }

    @FindBy(xpath = "//*[@id=\"gh-ac\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"gh-btn\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@class=\'rcnt\']")
    public WebElement resultTag;

    @FindBy(xpath = "//a[text()=\'Buy it now\']")
    public WebElement buyItNow;

    @FindBy(xpath = "//*[@id=\"e1-55\"]")
    public WebElement memory;

    @FindBy(xpath = "//*[@id=\'e1-157\']")
    public WebElement condition;

    @FindBy(xpath = "//a[text()=\'Best Match\']")
    public WebElement resultFilter;

    @FindBy(xpath = "//a[text()=\'Lowest price + P&P\']")
    public WebElement lowestPrice;

    @FindBy(xpath = "//li[@r=\"1\" and ./ul[1]/li[1]/span]")
    public WebElement firstPrice;














}
