package step;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static graphql.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.is;

public class stepDefinitions{
   WebDriver driver = new ChromeDriver();

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("user open the website {string}")
    public void openWebSite(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("user see cookie window")
    public void findCookie() {
        WebElement cookie = driver.findElement(By.xpath("//html/body/div[5]/div/div/div/button[2]"));
        cookie.isDisplayed();
    }

    @When("user click the cookie confirmation button")
    public void acceptCookie() {
        WebElement AcceptButton = driver.findElement(By.xpath("//html/body/div[5]/div/div/div/button[2]"));
        AcceptButton.click();
    }

    @Then("user should see the cookie window disappear")
    public void cookieNotDisplayed() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Given("user is on the Wolt homepage")
    public void homePage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://wolt.com/en/ltu", currentUrl);
    }

    @Then("user should see that page title as {string}")
    public void getTitle(String checkTitle) {
        String pageTitle = driver.getTitle();
        assertEquals(checkTitle, pageTitle);
    }

    @When("the page loads")
    public void pageLoad() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Then("user should see a banner with an advertisement")
    public void checkBanner() {
        WebElement homePageBanner = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]"));
        homePageBanner.isDisplayed();
    }

    @And("user should see a link to popular restaurants")
    public void linkPopularRestaurant() {
        WebElement linkPopularRest = driver.findElement(By.cssSelector(".wjhjMZ a"));
        linkPopularRest.isDisplayed();
        assertEquals("or view popular restaurants and stores in Vilnius", linkPopularRest.getText());
    }

    @And("user should see a delivery address search field")
    public void searchFieldIsDisplayed() {
        driver.findElement(By.cssSelector("#front-page-input")).isDisplayed();
    }

    @When("user clicks on the link")
    public void linkClick() {
        WebElement linkPopularRest = driver.findElement(By.cssSelector(".wjhjMZ a"));
        linkPopularRest.click();
    }

    @Then("user should be redirected to the restaurants page in Vilnius")
    public void restaurantsPage() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("/vilnius"));
        assertEquals("Vilnius \u2013 Wolt Delivery \u2013 Food, restaurants, grocery stores and shops \u2013 Wolt", driver.getTitle());
    }

    @When("user enters {string} in the input field")
    public void enterDeliveryAddress(String deliveryAddress) throws InterruptedException {
        WebElement deliveryAddressInput = driver.findElement(By.cssSelector("#front-page-input"));
        deliveryAddressInput.clear();
        deliveryAddressInput.sendKeys(deliveryAddress);
        deliveryAddressInput.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
    }

    @And("user presses Enter")
    public void pressEnter() {
        WebElement deliveryAddressInput = driver.findElement(By.cssSelector("#front-page-input"));
        deliveryAddressInput.sendKeys(Keys.ENTER);
    }

    @Then("user should be redirected to the {string}")
    public void checkRedirectPage(String deliveryAddress) throws InterruptedException {
        Thread.sleep(2000);
        WebElement visibleAddress = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/div[1]/div/div[1]/header/div[2]/div[1]/div/div/div/div/button/div[2]/span[2]"));
        visibleAddress.isDisplayed();
        assertTrue(driver.getCurrentUrl().contains("/discovery"));
        assertThat((visibleAddress).getText(), is(deliveryAddress));
    }}
