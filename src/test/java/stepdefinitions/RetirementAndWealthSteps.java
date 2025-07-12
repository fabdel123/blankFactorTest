package stepdefinitions;

import pages.RetirementAndWealthPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class RetirementAndWealthSteps {
    WebDriver driver;
    RetirementAndWealthPage retirementAndWealth;

    @When("BlankFactor page, verify on the page the value {string} copy the internal text")
    public void click_On_The_Text_And_After_On_The_Link_With_The_Value(String arg) {
        retirementAndWealth = new RetirementAndWealthPage(driver);
        retirementAndWealth.toCopyText(arg.trim());
    }

    @And("BlankFactor page, click on {string}")
    public void click_On_Lets_Get_Started(String arg) {
        retirementAndWealth = new RetirementAndWealthPage(driver);
        retirementAndWealth.clickLetsGetStarted(arg.trim());
    }

}
