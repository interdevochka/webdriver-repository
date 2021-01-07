import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class litecartMenuTest<id> {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\izoon\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void MyFirstTest() {
        driver.get(" http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("remember_me")).click();

        driver.findElement(By.name("login")).click();

        WebElement boxMenu = driver.findElement(By.id("box-apps-menu"));
        List<WebElement> menuItems = boxMenu.findElements(By.tagName("li"));

        for (int i = 0; i < menuItems.size(); i++) {
            WebElement menuItem = driver.findElement(By.id("box-apps-menu")).findElements(By.id("app-")).get(i);
            try {
                menuItem.findElement(By.tagName("h1"));
            } catch (NoSuchElementException e) {
                System.out.println("Нет заголовка h1 у " + menuItem.getText());
            }
            menuItem.click();
            try {
                WebElement subMenu = driver.findElement(By.id("box-apps-menu")).findElements(By.id("app-")).get(i).findElement(By.className("docs"));
                List<WebElement> subMenuItems = subMenu.findElements(By.tagName("li"));

                for (int b = 0; b < subMenuItems.size(); b++) {
                    WebElement subMenuItem = subMenuItems.get(b);
                    try {
                        subMenuItem.findElement(By.tagName("h1"));
                    } catch (NoSuchElementException e) {
                        System.out.println("Нет заголовка h1 у " + subMenuItem.getText());
                    }
                    subMenuItems.get(b).click();
                    subMenuItems = driver.findElement(By.id("box-apps-menu")).findElements(By.id("app-")).get(i).findElement(By.className("docs")).findElements(By.tagName("li"));
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();

            }

        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}