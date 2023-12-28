package pageFactoryTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageFactory.HeaderFactory;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

import java.time.Duration;

public class SkilloLoginTest {

    WebDriver driver;
    HeaderFactory header;
    HomePageFactory homePage;
    LoginPageFactory loginPage;
    RegisterPageFactory registerPage;

    @BeforeSuite
    public void setupBeforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupForEachTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        header = new HeaderFactory(driver);
        homePage = new HomePageFactory(driver);
        loginPage = new LoginPageFactory(driver);
        registerPage = new RegisterPageFactory(driver);
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

        header.clickOnLoginLinkButton();

        Assert.assertTrue(loginPage.isLoginTitleDisplayed());
        loginPage.enterUsername(username);
        loginPage.enterPassoword(password);
        loginPage.clickOnRememberMeBox();
        Assert.assertTrue(loginPage.isRememberMeSelected());
        loginPage.clickOnSignInButton();

        Assert.assertTrue(header.isSignOutButtonDisplayed());
    }
    @Test
    public void testRegistration(){

        homePage.loadPage();
        Assert.assertTrue(homePage.isPageLoaded());

        header.clickOnLoginLinkButton();
        Assert.assertTrue(loginPage.isLoginTitleDisplayed());
        loginPage.clickOnRegisterLinkButton();

        Assert.assertTrue(registerPage.isRegisterFormTitleDisplayed());
        registerPage.enterUsername();

    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}