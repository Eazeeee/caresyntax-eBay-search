package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BaseProperties;
import pageObjects.SearchFilter;
import pageObjects.Login;
import pageObjects.Register;

import java.util.List;

import static pageObjects.BaseProperties.answers;

public class SearchTests {
    private static WebDriver driver;
    private static WebDriverWait wait;



    @BeforeTest
    public static void preTest(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, BaseProperties.timeout);
        driver.get(BaseProperties.ebayURL);
    }

    @AfterTest
    public static void postTest(){

        driver.close();
        driver.quit();
    }

    @Test(priority = 1)
    public void signupTest(){


        Register registration = new Register(driver);
        BaseProperties connect = new BaseProperties();
        Login session = new Login(driver);

        // Click on the Register link to begin registration
        registration.registerlink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#swtActDiv")));

        // Generate and enter registration details and submit the form.
        String firstN = RandomStringUtils.randomAlphabetic(4);
        String lastN = RandomStringUtils.randomAlphabetic(4);
        String email = firstN + "@" + lastN + ".com";
        String passW = RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.randomNumeric(2);
        //Save email and password for the login test case.
        connect.email = email;
        connect.password = passW;

        // This is to see the registration details created
        System.out.println("First name is :" + firstN);
        System.out.println("Last name is :" + lastN);
        System.out.println("Email is :" + connect.email);
        System.out.println("Password is :" + connect.password);

        //Register the new user
        registration.firstnameField.sendKeys(firstN);
        registration.lastnameField.sendKeys(lastN);
        registration.emailField.sendKeys(email);
        registration.passwordField.sendKeys(passW);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ppaFormSbtBtn']")));
        registration.registerButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\' My eBay\']")));

        // Go to My eBay and get the UserID
        session.myEbaylink.click();
        String ebayIDstring = session.ebayID.getAttribute("innerHTML");
        String ebayID = ebayIDstring.substring(ebayIDstring.lastIndexOf('>') + 1, ebayIDstring.length() - 1);

        //Save the ID in an array.
        answers.add(ebayID);
        System.out.println(answers);

    }

    @Test(priority = 2)
    public void LoginTest() {

        SearchFilter filterSearch = new SearchFilter(driver);

        //Search for an item and add the result count to the array
        String search = "Intel NUC";
        filterSearch.searchBox.sendKeys(search);
        filterSearch.searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\'fTxt follow\']")));
        String results = filterSearch.resultTag.getAttribute("innerHTML");
        answers.add(results);

        //Apply filters and save to the array.
        filterSearch.buyItNow.click();
        filterSearch.memory.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'e1-157\']")));
        filterSearch.condition.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\'Best Match\']")));
        filterSearch.resultFilter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\'Lowest price + P&P\']")));
        filterSearch.lowestPrice.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'e1-3\']")));

        List<WebElement> allProducts = driver.findElements(By.xpath("//ul[@id=\'ListViewInner\']/li"));
        String firstString = allProducts.get(1).getText();
        String listprice = firstString.substring(firstString.indexOf('£'), firstString.indexOf('.') + 3);
        //System.out.println(listprice);
        answers.add(listprice);
        System.out.println(answers);


    }

}
