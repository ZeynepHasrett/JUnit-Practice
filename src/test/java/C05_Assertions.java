import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {
    // 4 farkli test method'u olusturarak asagidaki testleri yapin

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://www.bestbuy.com/ adresine gidin
        driver.get("https://www.bestbuy.com/");
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void urlTesti() {
        // Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void titleTesti() {
        // titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
        String unexpectedTitle = "Rest";
        String actualTitle = driver.getTitle();

        Assertions.assertNotEquals(unexpectedTitle, actualTitle);
    }

    @Test
    public void logoTesti() {
        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));

        Assertions.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void francaisLinkTesti() {
        // francaisLinkTest => Francais linkinin aktif oldugunu test edin
        WebElement francaisLinkElementi = driver.findElement(By.xpath("//*[.='Français']"));

        Assertions.assertTrue(francaisLinkElementi.isEnabled());
    }

}
