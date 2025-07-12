package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static utils.DriverFactory.driver;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isUrlCorrect(String expectedUrl) {
        return getCurrentUrl().equals(expectedUrl);
    }

}
