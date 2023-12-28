package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "homeIcon")
    WebElement skilloLogo;

    @FindBy(id = "nav-link-home")
    WebElement homeLinkButton;

    @FindBy(id = "nav-link-login")
    WebElement loginLinkButton;

    @FindBy(id = "nav-link-profile")
    WebElement profileLinkButton;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLinkButton;

    @FindBy(xpath = "//i[@class='fas fa-sign-out-alt fa-lg']")
    WebElement signOutButton;

    public void clickOnHomelinkButton(){
        homeLinkButton.click();
    }
    public void clickOnLoginLinkButton(){
        loginLinkButton.click();
    }
    public void clickOnProfileLinkButton(){
        profileLinkButton.click();
    }
    public void clickOnNewPostLinkButton(){
        newPostLinkButton.click();
    }
    public void clickOnSignOutButton(){
        signOutButton.click();
    }
}
