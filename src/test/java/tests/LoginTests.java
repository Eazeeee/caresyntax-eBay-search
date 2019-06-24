/*
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BaseProperties;
import pageObjects.SearchFilter;
import pageObjects.Login;

import java.util.List;

import static pageObjects.BaseProperties.answers;


public class LoginTests {


    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeTest
    public static void preTest() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, BaseProperties.timeout);
        driver.get(BaseProperties.ebayURL);
    }

    */
/*@AfterTest
    public static void postTest(){

        driver.close();
        driver.quit();
    }*//*



    @Test(priority = 2)
    public void loginTest() {

        Login session = new Login(driver);
        SearchFilter cart = new SearchFilter(driver);
        session.SignInlink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"GREET-SIGN-IN-TO-EBAY\"]")));
        //  session.usernameField.sendKeys(BaseProperties.email);
        //  session.pwordField.sendKeys(BaseProperties.password);
        session.usernameField.sendKeys("hDPN@GwbV.com");
        session.pwordField.sendKeys("oZyf23");
        session.signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\' My eBay\']")));
        session.myEbaylink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"page-name\"]")));
        String ebayIDstring = session.ebayID.getAttribute("innerHTML");
        String ebayID = ebayIDstring.substring(ebayIDstring.lastIndexOf('>') + 1, ebayIDstring.length() - 1);
        answers.add(ebayID);

        cart.searchBox.sendKeys("Intel NUC");
        cart.searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\'fTxt follow\']")));
        String results = cart.resultTag.getAttribute("innerHTML");
        answers.add(results);

        cart.buyItNow.click();
        cart.memory.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'e1-157\']")));
        cart.condition.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\'Best Match\']")));
        cart.resultFilter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\'Lowest price + P&P\']")));
        cart.lowestPrice.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'e1-3\']")));

        List<WebElement> allProducts = driver.findElements(By.xpath("//ul[@id=\'ListViewInner\']/li"));
        String firstString = allProducts.get(1).getText();
        String listprice = firstString.substring(firstString.indexOf('£'), firstString.indexOf('.') + 3);
        System.out.println(firstString);




   */
/* @Test
    public void searchTests(){

        SearchFilter cart = new SearchFilter(driver);
        cart.searchBox.sendKeys("Intel NUC");
        cart.searchButton.click();




    }
*//*


    }
    }

*/
