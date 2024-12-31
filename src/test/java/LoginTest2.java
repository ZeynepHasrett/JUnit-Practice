import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest2 {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Chrome driver'ın yolu
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://example.com/login");
    }

    @Test
    public void testLogin() {
        // Giriş alanlarını bul ve verileri gir
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password123");
        loginButton.click();
        // Giriş başarılı mı kontrol et
        String expectedUrl = "http://example.com/dashboard";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit(); // Tarayıcıyı kapat
    }

}