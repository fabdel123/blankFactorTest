package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigReader;

import java.util.List;

import static utils.DriverFactory.driver;

public class HomePage extends BasePage {

    private final By acceptCookiesBtn = By.cssSelector("div.cky-notice-group button.cky-btn.cky-btn-accept");
    private final By industriesLink = By.id("menu-item-4871");
    private final By industriesTitleLink = By.cssSelector("h6.industry-item__title");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getUrl() {
        driver.get(ConfigReader.get("base.url"));
    }


    public void click() {
        //To wait until the sub-elements appear Wait until loaded the element and then perform the action
        waitForElementAndClick(acceptCookiesBtn);
    }

    public void hoverMouseAndClickLinkText(String linkText) {
        //Verify that the field "Industries" menu is visible
        waitForElement(industriesLink);
        Assertions.assertEquals("Industries", driver.findElement(industriesLink).getText());

        // Hover over the element
        WebElement hoverable = driver.findElement(industriesLink);
        new Actions(driver).moveToElement(hoverable).perform();

        //Obtain all available titles under the industry
        List<WebElement> industryTitles = driver.findElements(industriesTitleLink);
        for (WebElement title : industryTitles) {
            String actualText = title.getText().trim();
            if (actualText.equals(linkText)) {
                title.click();
                break;
            }
        }
    }

}
