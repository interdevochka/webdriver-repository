//package ru.stqa.training.selenium.vns;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class Basket19PageProduct {

    @Test
    public void add3Ducks(WebDriver driver, String url, int i) throws InterruptedException {  //а зачем мне здесь этот эксепшен?

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(url);
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

    }



}

