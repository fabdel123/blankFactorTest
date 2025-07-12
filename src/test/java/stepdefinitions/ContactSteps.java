package stepdefinitions;

import org.junit.Assert;
import pages.ContactPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static utils.DriverFactory.driver;

public class ContactSteps {
    WebDriver webDriver;
    ContactPage contactPage;

    @Then("BlankFactor page, get the page URL")
    public void get_Current_Url() {
        contactPage = new ContactPage(driver);
        contactPage.getCurrentUrl();
    }

    @Then("BlankFactor page, verify the page URL is correct {string}")
    public void get_Current_Url_Title(String arg) {
        contactPage = new ContactPage(driver);
        contactPage.isUrlCorrect(arg);
        Assert.assertTrue(contactPage.isUrlCorrect(arg));
    }
    

}
