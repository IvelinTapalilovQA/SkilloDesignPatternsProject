package pageObjectTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.Header;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.time.Duration;

public class SkilloTests {

    WebDriver driver;
    Header header;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeSuite
    public void setupBeforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupForEachTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        header = new Header(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "credentials")
    public Object[][] generatorCredentials() {
        return new Object[][]{
                {"testacc", "Testacc12"},// Verify login with username
                {"testacc@gmail.com", "Testacc12"},//Verify login with Email
                {"TestAdminAcc", "TestAdminAcc1"}// verify admin role login with username
        };
    }

    @Test(dataProvider = "credentials")
    public void testLogin(String username, String password) {

        homePage.loadPage();
        Assert.assertTrue(homePage.isPageLoaded());

        header.clickOnLoginLink();

        Assert.assertTrue(loginPage.isLoginTitleDisplayed());
        loginPage.enterUsername(username);
        loginPage.enterPassoword(password);
        loginPage.clickRememberMeBox();
        Assert.assertTrue(loginPage.isRememberMeSelected());
        loginPage.clickOnSignInButton();

        Assert.assertTrue(header.isSignOutButtonDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}