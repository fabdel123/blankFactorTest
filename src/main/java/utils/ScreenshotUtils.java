package utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenshotUtils {

    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtils.class);


    public static <WebDriver> void takeScreenshot(WebDriver driver, String stepName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String filename = "screenshot_" + "_" + stepName.replaceAll("\\s+", "_") + "_" + timestamp + ".png";
            File dest = new File("target/screenshots/" + filename);
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot: {}", e.getMessage());
        }
    }

    public static void attachScreenshot(WebDriver driver, Scenario scenario) {
        if (scenario.isFailed() || scenario.getStatus().name().equals("PASSED")) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot - " + scenario.getName());
            } catch (Exception e) {
                logger.error("❌ Error attaching screenshot: {}", e.getMessage());
            }
        }
    }

}
