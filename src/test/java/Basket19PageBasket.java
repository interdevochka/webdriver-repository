//package ru.stqa.training.selenium.vns;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Basket19PageBasket {

    @Test
    public void allDucksDelete(WebDriver driver, String url) throws InterruptedException {

        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // 5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        WebElement cart_button = driver.findElement(By.id("cart"));
        cart_button.click(); //кликаем по кнопке cart
        Thread.sleep(2000);

        for (int i = 0; i < 3; i++) {

            List<WebElement> shortcuts = driver.findElements(By.cssSelector("ul[class='shortcuts']")); // берем список элементов класса li

            if (shortcuts.size() > 0) {

                WebElement shortcuts_pannel = driver.findElement(By.cssSelector("ul[class='shortcuts']"));//панель маленьких уток
                List<WebElement> liDuckList = shortcuts_pannel.findElements(cssSelector("li")); // берем список элементов класса li
                WebElement liDuck1;

                // Удалять товары
                //если блок с маленькими утками есть, то находим его размер
                int size = liDuckList.size();

                for (int j = 0; j < size - 1; j++) {
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
            }

            WebElement remove_cart_item = driver.findElement(By.name("remove_cart_item"));
            remove_cart_item.click();

        }
    }


}
