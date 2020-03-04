package googlesearch;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchStepDefs extends StepDefs {

    @Before()
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @After()
    public void closeBrowser(){
        driver.quit();
    }

    @Given("I navigate to Google home page")
    public void i_navigate_to_Google_home_page() {
        openURL("https://www.google.com/");
    }

    @When("I type search pattern {string}")
    public void i_type_search_pattern(String searchPattern) {
        inputText("//input[@name='q']", searchPattern);
    }

    @When("I click on Search button")
    public void i_click_on_Search_button() {
        clickElement("(//input[@value='Buscar con Google'])[1]");
    }

    @Then("I found {string} match")
    public void i_found_match(String searchPattern) {
        Assert.assertTrue(isMatchFound("//h3[contains(@class, 'LC20lb')]", searchPattern));
    }
}
