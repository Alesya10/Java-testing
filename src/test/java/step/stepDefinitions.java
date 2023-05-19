package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class stepDefinitions<title> {
    WebDriver driver = new ChromeDriver();

    @Given("I open the website {string}")
    public void openWebSite(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("I see cookie window")
    public void findCookie() {
        driver.findElement(By.xpath("//html/body/div[5]/div/div/div/button[2]")).isDisplayed();
    }

    @When("I click the cookie confirmation button")
    public void acceptCookie() {
        WebElement AcceptButton = driver.findElement(By.xpath("//html/body/div[5]/div/div/div/button[2]"));
        AcceptButton.click();
    }

    @Then("I should see the cookie window disappear")
    public void cookieNotDisplayed() throws InterruptedException {
        Thread.sleep(1000);
    }


    @When("I see that the page title as {string}")
    public void getTitle(String checkTitle) {
        String pageTitle = driver.getTitle();
        assertEquals(checkTitle, pageTitle);
    }

    @And("Banner on the home page should be displayed")
    public void bannerIsDisplayed() {
        WebElement homePageBanner = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]"));
        homePageBanner.isDisplayed();
    }

    @And("link to popular restaurants is displayed")
    public void linkToPopularRestaurantsIsDisplayed() {
        WebElement linkPopularRest = driver.findElement(By.cssSelector(".wjhjMZ a"));
        linkPopularRest.isDisplayed();
    }

    @And("delivery address search field is displayed")
    public void searchFieldIsDisplayed() {
      driver.findElement(By.cssSelector("#front-page-input")).isDisplayed();
    }

    @When("I input {string} in 'Search' textfield")
    public void inputAddress(String address) {
        WebElement searchAddressDelivert = driver.findElement(By.cssSelector("#front-page-input"));
        searchAddressDelivert.sendKeys(address);
    }

    @Then("I expect to see dropdown with all suggested addresses")
    public void seeDropdownList() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
