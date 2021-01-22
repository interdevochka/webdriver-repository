//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class Basket13_v4 {


    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void main() throws InterruptedException {  //а зачем мне здесь этот эксепшен?

        for (int i = 0; i < 3; i++) {

            // 1) открыть главную страницу
            driver.get("http://localhost/litecart/public_html/en/");
            Thread.sleep(1000);

            // 2) открыть первый товар из списка
            WebElement mostPopularBlock = driver.findElement(By.id("box-most-popular")); // выбираем блок most popular

            List<WebElement> liList = mostPopularBlock.findElements(cssSelector("li")); // берем список элементов класса li
            WebElement li = liList.get(0);

            //находим первый элемент со ссылкой вида a href и кликаем
            WebElement a = li.findElement(By.tagName("a"));
            a.click(); //кликаем на первую утку в списке
            Thread.sleep(1000);

            // 2) добавить его в корзину (при этом может случайно добавиться товар, который там уже есть, ничего страшного)
            WebElement add_cart_button;

            List<WebElement> skuList = driver.findElements(By.name("options[Size]")); //кнопка для желтой утки выбираем размер
            boolean isYellowExist = true;
            isYellowExist = skuList.size()>0;

            if (isYellowExist) {
                WebElement size = driver.findElement(cssSelector("select[name='options[Size]']"));
                size.click();
                Select select = new Select(size);
                Thread.sleep(2000);
                select.selectByVisibleText("Small");
                Thread.sleep(1000);
            }

            add_cart_button = driver.findElement(By.name("add_cart_product"));
            add_cart_button.click(); //кликаем по кнопке add_cart_product


           // WebElement add_to_cart_button = driver.findElement(By.name("add_cart_product"));
           // add_to_cart_button.click();

            // 3) подождать, пока счётчик товаров в корзине обновится
            Thread.sleep(1000);

            // подождать, пока новый товар не добавится в корзину
            switch(i) {
                case 0:
                    wait.until(textToBePresentInElement(driver.findElement(By.cssSelector("span[class='quantity']")), "1"));
                    break;
                case 1:
                    wait.until(textToBePresentInElement(driver.findElement(By.cssSelector("span[class='quantity']")), "2"));
                    break;
                case 2:
                    wait.until(textToBePresentInElement(driver.findElement(By.cssSelector("span[class='quantity']")), "3"));
                    break;
                default:
                    System.out.println("Количество товаров корзине увеличено");
            }

        } //конец цикла


      // 5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        WebElement cart_button = driver.findElement(By.id("cart"));
        cart_button.click(); //кликаем по кнопке cart
        Thread.sleep(2000);

        WebElement shortcuts_pannel = driver.findElement(By.cssSelector("ul[class='shortcuts']"));//панель маленьких уток
        List<WebElement> liDuckList = shortcuts_pannel.findElements(cssSelector("li")); // берем список элементов класса li
        WebElement liDuck1;

        // Удалять товары
        //если блок с маленькими утками есть, то находим его размер
        int size = liDuckList.size();

        for (int i = 0; i < size-1; i++) {
            shortcuts_pannel = driver.findElement(By.cssSelector("ul[class='shortcuts']"));//панель маленьких уток
            liDuckList = shortcuts_pannel.findElements(cssSelector("li")); // берем список элементов класса li
            liDuck1 = liDuckList.get(0); //выбираем первую утку-левую

            //находим левую маленькую утку и кликаем
            WebElement little_duck = liDuck1.findElement(By.tagName("a"));
            little_duck.click(); //кликаем на первую утку в списке
            Thread.sleep(1000);

            // находим таблицу внизу
            WebElement checkout = driver.findElement(By.id("checkout-summary-wrapper"));
            WebElement box = checkout.findElement(By.id("box-checkout-summary"));
            WebElement order = box.findElement(By.id("order_confirmation-wrapper"));
            WebElement table = box.findElement(By.tagName("table"));

            WebElement remove_cart_item = driver.findElement(By.name("remove_cart_item"));
            remove_cart_item.click();
            Thread.sleep(2000);

            // после каждого удаления подождать, пока внизу обновится таблица
            wait.until(stalenessOf(table));
        }

        WebElement remove_cart_item = driver.findElement(By.name("remove_cart_item"));
        remove_cart_item.click();

    }


    @After
    public void stop() {
        driver.quit();
        driver = null;

    }

}

