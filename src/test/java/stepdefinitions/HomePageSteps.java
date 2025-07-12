package stepdefinitions;

import pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver;
    HomePage homePage;

    @Given("Navigate to the page blankFactor")
    public void navigate_To_The_Page_Blankfactor() {
        homePage = new HomePage(driver);
        homePage.getUrl();
    }

    @And("BlankFactor page, Click the cookie policy Click on the button with the value ACCEPT OUR POLICY")
    public void click_Any_Value() {
        homePage = new HomePage(driver);
        homePage.click();
    }

    @But("BlankFactor page, hover text title with the value Industries and after click on the link with the value {string}")
    public void hover_Text_Title_And_Click_Link(String arg) {
        homePage = new HomePage(driver);
        homePage.hoverMouseAndClickLinkText(arg.trim());
    }

}
