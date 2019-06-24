package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BaseProperties;
import pageObjects.Register;

public class RegistrationTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private String mail = "";
    private String pword = "";



    @BeforeTest
    public static void preTest(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, BaseProperties.timeout);
        driver.get(BaseProperties.ebayURL);
    }

    /*@AfterTest
    public static void postTest(){

        driver.close();
        driver.quit();
    }*/

    @Test(priority = 1)
    public void signupTest(){


        Register registration = new Register(driver);
        BaseProperties connect = new BaseProperties();

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

        System.out.println("First name is :" + firstN);
        System.out.println("Last name is :" + lastN);
        System.out.println("Email is :" + connect.email);
        System.out.println("Password is :" + connect.password);

        registration.firstnameField.sendKeys(firstN);
        registration.lastnameField.sendKeys(lastN);
        registration.emailField.sendKeys(email);
        registration.passwordField.sendKeys(passW);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ppaFormSbtBtn']")));
        registration.registerButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\' Daily Deals\']")));

        //Logout to end the test.
        registration.logoutLink.click();
    }

}
