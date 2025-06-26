package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;


import java.util.List;

import static utils.DriverFactory.driver;

public class FunctionsSteps {

    public FunctionsSteps(WebDriver driver) {
    }

    public void getUrl() {
        driver.get("http://blankfactor.com");
    }

    public void click() throws InterruptedException {
        //To wait until the sub-elements appear
        Thread.sleep(3000);

        //Wait until loaded the element and then perform the action
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cky-notice-group button.cky-btn.cky-btn-accept"))).click();

    }

    public void hoverMouseAndClickLinkText(String linkText) throws InterruptedException {
        //To wait until the sub-elements appear
        Thread.sleep(3000);

        //Verify that the "Industries" menu is visible
        Assertions.assertEquals("Industries", driver.findElement(By.id("menu-item-4871")).getText());

        // Hover over the element
        WebElement hoverable = driver.findElement(By.id("menu-item-4871"));
        new Actions(driver).moveToElement(hoverable).perform();

        //Obtain all available titles under the industry
        List<WebElement> industryTitles = driver.findElements(By.cssSelector("h6.industry-item__title"));
        for (WebElement title : industryTitles) {
            String actualText = title.getText().trim();
            if (actualText.equals(linkText)) {
                title.click();
                break;
            }
        }
    }

    public void toCopyText(String cardText) throws InterruptedException {
        //To wait until the sub-elements appear
        Thread.sleep(2000);

        //Scroll to the bottom
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //Listing cards existing
        List<WebElement> frontCards = driver.findElements(By.cssSelector("div.card-text"));
        if (frontCards.isEmpty()) {
            System.out.println("No cards were found with the class 'card-text'");
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
            System.out.println("Visible text: [" + text + "]");

            //Conditional to verify the internal text of the card
            if (text.contains(expected)) {
                found = true;

                new Actions(driver).moveToElement(front).perform();
                Thread.sleep(1000);

                WebElement backCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.card-text.small")));

                String content = backCard.getText().trim();
                System.out.println("Copied text: " + content);
                DataStore.savedData = content;
                break;
            }
        }

        //Message when the card text it wasn´t found
        if (!found) {
            System.out.println("No card with the text was found: " + cardText);
        }
    }

    public void clickLetsGetStarted(String resultText) throws InterruptedException {
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> industryTitles = driver.findElements(By.cssSelector("a.btn.btn-white-empty.hover-color-aqua.btn-large"));
        for (WebElement title : industryTitles) {
            String actualText = title.getText().trim();
            if (actualText.equals(resultText)) {
                title.click();
                break;
            }
        }
    }

    public void verifyUrlAndPrint() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }


}