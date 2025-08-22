package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static utils.DriverFactory.driver;

public class RetirementAndWealthPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(RetirementAndWealthPage.class);

    private final By divCardText = By.cssSelector("div.card-text");
    private final By divCardTextSmall = By.cssSelector("div.card-text.small");
    private final By hoverBtn = By.cssSelector("a.btn.btn-white-empty.hover-color-aqua.btn-large");



    public RetirementAndWealthPage(WebDriver driver) {
        super(driver);
    }

    public void toCopyText(String cardText) {

        //Scroll to the bottom
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Listing cards existing
        List<WebElement> frontCards = driver.findElements(divCardText);
        if (frontCards.isEmpty()) {
            logger.warn("No cards were found with the class 'card-text'");
            return;
        }
        boolean found = false;

        //Validate the internal text information of the card
        for (WebElement front : frontCards) {
            js.executeScript("arguments[0].scrollIntoView(true);", front);

            //Capture card text, replace spaces and print to result
            String rawText = (String) js.executeScript("return arguments[0].innerText;", front);
            String text = rawText.replaceAll("\\s+", " ").trim();
            String expected = cardText.trim().replaceAll("\\s+", " ");
            logger.info("Visible text: [{}]", text);

            //Conditional to verify the internal text of the card
            if (text.contains(expected)) {
                found = true;

                new Actions(driver).moveToElement(front).perform();

                WebElement backCard = wait.until(ExpectedConditions.visibilityOfElementLocated(divCardTextSmall));

                String content = backCard.getText().trim();
                logger.info("Copied text: {}", content);
                DataStore.savedData = content;
                break;
            }
        }

        //Message when the card text it wasn´t found
        if (!found) {
            logger.warn("No card with the text was found: {}", cardText);
        }
    }

    public void clickLetsGetStarted(String resultText) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        waitForElement(hoverBtn);
        List<WebElement> industryTitles = driver.findElements(hoverBtn);
        for (WebElement title : industryTitles) {
            String actualText = title.getText().trim();
            if (actualText.equals(resultText)) {
                js.executeScript("arguments[0].click();",title);
                break;
            }
        }
    }

}
