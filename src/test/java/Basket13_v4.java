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

public class Basket13_v4 {


    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void main() throws InterruptedException {  //а зачем мне здесь этот эксепшен?

        for (int i = 0; i < 3; i++) {

            // 1) открыть главную страницу
            //тут похоже нужен цикл...
            driver.get("http://localhost/litecart/public_html/en/");

            // 2) открыть первый товар из списка
            WebElement mostPopularBlock = driver.findElement(By.id("box-most-popular")); // выбираем блок most popular


            List<WebElement> liList = mostPopularBlock.findElements(cssSelector("li")); // берем список элементов класса li
            WebElement li = liList.get(0);

            //находим первый элемент со ссылкой вида a href и кликаем
            WebElement a = li.findElement(By.tagName("a"));
            a.click(); //кликаем на первую утку в списке
            Thread.sleep(1000);

            // WebElement first_duck = li.findElement(By.xpath("//a[contains(@href,'red-duck-p-3')]"));  //ищем и нажимаем на первую утку
            //first_duck.click();
            //Thread.sleep(2000);

            // 2) добавить его в корзину (при этом может случайно добавиться товар, который там уже есть, ничего страшного)
            WebElement add_cart_button;

            //WebElement sku = driver.findElement(By.name("options[Size]"));
            List<WebElement> skuList = driver.findElements(By.name("options[Size]")); //кнопка для желтой утки выбираем размер
            boolean isYellowExist = true;
            isYellowExist = skuList.size()>0;


           // isYellowExist = sku.isDisplayed();

            if (isYellowExist) {
                WebElement size = driver.findElement(cssSelector("select[name='options[Size]']"));
                size.click();
                Select select = new Select(size);
                Thread.sleep(1000);
                select.selectByVisibleText("Medium +$2.50");
                Thread.sleep(1000);
            }

            add_cart_button = driver.findElement(By.name("add_cart_product"));
            add_cart_button.click(); //кликаем по кнопке add_cart_product


           // WebElement add_to_cart_button = driver.findElement(By.name("add_cart_product"));
           // add_to_cart_button.click();

            // 3) подождать, пока счётчик товаров в корзине обновится
            Thread.sleep(1000);


        } //конец цикла


      // 5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        WebElement cart_button = driver.findElement(By.id("cart"));
        cart_button.click(); //кликаем по кнопке cart
        Thread.sleep(1000);

        WebElement shortcuts_pannel = driver.findElement(By.className("shortcuts"));//панель маленьких уток
        List<WebElement> liDuckList = shortcuts_pannel.findElements(cssSelector("li")); // берем список элементов класса li
        WebElement liDuck1 = liDuckList.get(0); //выбираем первую утку-левую

        //проверяем, есть ли блок с маленькими утками
        boolean duckExist = liDuckList.size() >0;
        //если блок с маленькими утками есть, то находим его размер
        int size = liDuckList.size();

        for (int i = 0; i < size; i++) {


        shortcuts_pannel = driver.findElement(By.className("shortcuts"));//панель маленьких уток
        liDuckList = shortcuts_pannel.findElements(cssSelector("li")); // берем список элементов класса li
        liDuck1 = liDuckList.get(0); //выбираем первую утку-левую


        //находим левую маленькую утку и кликаем
        WebElement little_duck = liDuck1.findElement(By.tagName("a"));
        little_duck.click(); //кликаем на первую утку в списке
        Thread.sleep(1000);

        boolean isLeftLittleDuck = true;
        isLeftLittleDuck = little_duck.isDisplayed();

        // 6) удалить все товары из корзины один за другим,
        if (isLeftLittleDuck) {
            little_duck.click();
            Thread.sleep(1000);

        }

        WebElement remove_cart_item = driver.findElement(By.name("remove_cart_item"));
        remove_cart_item.click();

        // после каждого удаления подождать, пока внизу обновится таблица
            Thread.sleep(1000);
    }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;

    }

}

