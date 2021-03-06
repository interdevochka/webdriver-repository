import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class firstSeleniumTest {
        private WebDriver driver;
        private WebDriverWait wait;

        @Before
        public void start() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\izoon\\Documents\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
        }

        @Test
        public void MyFirstTest() {
            driver.get("https://www.google.com");
            driver.findElement(By.name("q")).sendKeys("webdriver");
            driver.findElement(By.name("btnG")).click();
            wait.until(titleIs("webdriver - поиск в Google"));
        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
    }