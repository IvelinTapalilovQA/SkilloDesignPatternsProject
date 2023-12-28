package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    WebDriver driver;
    private final String URL_PROFILE = "http://training.skillo-bg.com:4300/users/";

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    @FindBy(tagName = "h2")
    WebElement profileUsername;


    //Action Methods
    public boolean isProfilePageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlContains(URL_PROFILE));
    }

    public String getProfileUsername() {
        return profileUsername.getText();
    }

}
