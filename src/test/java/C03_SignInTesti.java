import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_SignInTesti {

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

    @BeforeEach
    public void girisEkrani() {
        // 1- https://babayigit.net/test/ adresine gidin
        driver.get("https://babayigit.net/test/");

        // 2- Login butonuna tıklayın
        driver.findElement(By.xpath("//*[@*='img/login.png']"))
                .click();
    }

    @AfterEach
    public void testBitir() {
        System.out.println("\nTest Tamamlandi\n");
    }

    @Test
    public void negativeLogin() {

        // 3- Username kısmına “babayigit” yazdırın
        driver.findElement(By.id("username"))
                .sendKeys("babayigit");

        // 4- Password kısmına baba123 yazdırın
        driver.findElement(By.id("password"))
                .sendKeys("baba123");

        // 5- Login butonuna tıklayın
        driver.findElement(By.xpath("//*[@*='button']"))
                .click();

        // 6- Başarılı giriş yapılamadığını doğrulayın
        String expectedMessage = "The username or password is incorrect.";
        String actualMessage = driver.findElement(By.id("result")).getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Giris Yapilamadi. Bilgi Hatasi Var\nThe username or password is incorrect.");
        }

    }

    @Test
    public void positiveLogin() {

        // 7- Login Sayfasında kullanıcı adına “babayigit” Password kısmına “Mb3471&” yazdırın
        driver.findElement(By.id("username"))
                .sendKeys("babayigit");

        driver.findElement(By.id("password"))
                .sendKeys("Mb3471&");

        // 8- Login butonuna tıklayın
        driver.findElement(By.xpath("//*[@*='button']"))
                .click();

        // 9- Başarılı giriş yapıldığını doğrulayın
        String expectedMessage = "Successful entry!";
        String actualMessage = driver.findElement(By.id("result")).getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Giris Yapildi.\nSuccessful entry!");
        }

    }

}


