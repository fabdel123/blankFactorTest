package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ScreenshotUtils;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        ScreenshotUtils.takeScreenshot(driver, scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        ScreenshotUtils.takeScreenshot(driver, scenario.getName());
        ScreenshotUtils.attachScreenshot(DriverFactory.getDriver(), scenario);
    }

}
