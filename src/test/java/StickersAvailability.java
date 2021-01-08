import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class StickersAvailability {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void MyFirstTest() {
        driver.get(" http://localhost/litecart/public_html/en/");

        //шаг 1. Находим блок всех уток
        WebElement allDuckBlock = driver.findElement(By.className("listing-wrapper products"));


        //шаг 2. Составляем список всех уток
        ArrayList<WebElement> webElements = new ArrayList<WebElement>();
        webElements = allDuckBlock.findElements(By.className("image-wrapper"));

        //шаг 3. В цикле проверяем стикер каждой отдельной утки
        ArrayList<WebElement> stickerList = new ArrayList<WebElement>();
        for (int i = 0; i < webElements.size(); i++) {


            stickerList = webElements.get(i).findElement(By.className("sticker"));

            if () {
                throw new Exception("Стикера нету"); //стикер не найден, то выбрасывается исключение
            }

            addMethod(5);

        }






        private void addMethod(int number) {


            }


    }

    private void addMethod() {
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

