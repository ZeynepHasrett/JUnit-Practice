import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C06_LoginTesti {

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void loginTesti() throws InterruptedException {

        // testotomasyonu.com sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // Account butonuna tiklayin
        driver.findElement(By.xpath("(//div[@class='cart-bar'])[1]"))
                .click();

        // Email ve sifre alanlarini doldurun
        driver.findElement(By.id("email"))
                .sendKeys("wise@gmail.com");

        driver.findElement(By.id("password"))
                .sendKeys("12345");

        // Sign In butonuna tiklayin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // Başarili bir sekilde giris yapildigini test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement logoutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        // logout butonuna tiklayin
        logoutButonu.click();

    }

}
