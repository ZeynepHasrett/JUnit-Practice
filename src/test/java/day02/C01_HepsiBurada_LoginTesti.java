package day02;

import org.checkerframework.common.util.count.report.qual.ReportUse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01_HepsiBurada_LoginTesti {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void loginTesti() throws InterruptedException {

        driver.get("https://www.hepsiburada.com");

        Actions actions = new Actions(driver);
        Thread.sleep(2);

        WebElement girisYapButonu = driver.findElement(By.xpath("//*[@id='myAccount']"));
        actions.moveToElement(girisYapButonu).perform();

        driver.findElement(By.id("login"))
                .click();

        driver.findElement(By.id("txtUserName")).sendKeys("uyelik@babayigit.net");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Ps7hDbPv");

        Thread.sleep(2);

        driver.findElement(By.id("btnLogin"))
                .click();
    }

}
