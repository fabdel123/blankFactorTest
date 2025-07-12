package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverFactory.driver;

public class BasePage {

    public BasePage(WebDriver driver) {
    }
    //Explicits waits
    protected void waitForElement(By argLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(argLocator));
    }

    //Explicits waits and click
    protected void waitForElementAndClick(By argLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(argLocator)).click();
    }
}