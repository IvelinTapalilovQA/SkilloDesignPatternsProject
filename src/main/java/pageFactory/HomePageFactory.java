package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    private static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/all";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(PAGE_URL);
    }

    public boolean isPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }
}


