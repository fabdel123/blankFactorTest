package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
    WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
