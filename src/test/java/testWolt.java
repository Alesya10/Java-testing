import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testWolt {
    @Test
    public void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wolt.com/en/ltu");
        String title = driver.getTitle();
        assertEquals("Wolt Delivery: Food and more \u2013 Lithuania", title);
        WebElement AcceptButton = driver.findElement(By.xpath("//html/body/div[5]/div/div/div/button[2]"));
        AcceptButton.click();

        WebElement homePageBanner = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]"));
        homePageBanner.isDisplayed();
        WebElement bannerImg = driver.findElement(By.cssSelector("img"));
        String imgUrl = bannerImg.getAttribute("src");
        assertEquals("https://consumer-static-assets.wolt.com/frontpage-assets/hero-images/5_Friday.jpg", imgUrl);

        WebElement linkPopularRest = driver.findElement(By.cssSelector(".wjhjMZ a"));
        linkPopularRest.isDisplayed();
        String hrefLinkRest = linkPopularRest.getAttribute("href");
        assertEquals("https://wolt.com/en/ltu/vilnius", hrefLinkRest);

        WebElement searchAddressDelivert = driver.findElement(By.cssSelector("#front-page-input"));
        searchAddressDelivert.isDisplayed();
        searchAddressDelivert.sendKeys("Riga");
        driver.quit();
    }
}
