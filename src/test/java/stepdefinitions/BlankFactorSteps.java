package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.FunctionsSteps;

public class BlankFactorSteps {
    WebDriver driver;
    FunctionsSteps functionsSteps;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @Given("Navigate to the page blankFactor")
    public void navigate_to_the_page_blank_factor() {
        functionsSteps = new FunctionsSteps(driver);
        functionsSteps.getUrl();
    }

    @And("BlankFactor page, Click the cookie policy Click on the button with the value ACCEPT OUR POLICY")
    public void click_Any_Value() throws InterruptedException {
        functionsSteps = new FunctionsSteps(driver);
        functionsSteps.click();
    }

    @But("BlankFactor page, hover text title with the value Industries and after click on the link with the value {string}")
    public void hover_text_title_and_click_link(String arg) throws InterruptedException {
        functionsSteps = new FunctionsSteps(driver);
        functionsSteps.hoverMouseAndClickLinkText(arg.trim());
    }

    @When("BlankFactor page, verify on the page the value {string} copy the internal text")
    public void click_on_the_text_And_After_On_the_Link_With_The_Value(String arg) throws InterruptedException {
        functionsSteps = new FunctionsSteps(driver);
        functionsSteps.toCopyText(arg.trim());
    }

    @And("BlankFactor page, click on {string}")
    public void i_click_on_lets_get_started(String arg) throws InterruptedException {
        functionsSteps = new FunctionsSteps(driver);
        functionsSteps.clickLetsGetStarted(arg.trim());
    }

    @Then("BlankFactor page, verify the page URL and print the page title")
    public void i_verify_url_and_print_title() throws InterruptedException {
        functionsSteps = new FunctionsSteps(driver);
        functionsSteps.verifyUrlAndPrint();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}