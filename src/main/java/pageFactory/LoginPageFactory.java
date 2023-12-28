package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".h4.mb-4")
    WebElement loginTitle;
    @FindBy(id = "defaultLoginFormUsername")
    WebElement usernameField;
    @FindBy(id = "defaultLoginFormPassword")
    WebElement passwordField;
    @FindBy(xpath = "//input[@formcontrolname='rememberMe']")
    WebElement rememberMeCheckBox;
    @FindBy(xpath = "//a[@href='/users/register']")
    WebElement registerLink;
    @FindBy(id = "sign-in-button")
    WebElement signInButton;


    public boolean isLoginTitleDisplayed() {
        return loginTitle.isDisplayed();
    }
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    public void enterPassoword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickOnRememberMeBox() {
        rememberMeCheckBox.click();
    }
    public void clickOnSignInButton() {
        signInButton.click();
    }
}
