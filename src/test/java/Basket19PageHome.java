//package ru.stqa.training.selenium.vns;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class Basket19PageHome {


    private WebDriver driver;
    private WebDriverWait wait;


    @Test
    public String select1duck(WebDriver driver, String url) throws InterruptedException {  //а зачем мне здесь этот эксепшен?

        WebDriverWait wait = new WebDriverWait(driver, 10);
            // 1) открыть главную страницу
            driver.get(url);

            // 2) открыть первый товар из списка
            WebElement mostPopularBlock = driver.findElement(By.id("box-most-popular")); // выбираем блок most popular

            List<WebElement> liList = mostPopularBlock.findElements(cssSelector("li")); // берем список элементов класса li
            WebElement li = liList.get(0);

            //находим первый элемент со ссылкой вида a href и кликаем
            WebElement a = li.findElement(By.tagName("a"));
            a.click(); //кликаем на первую утку в списке
            Thread.sleep(1000);

            String result = driver.getCurrentUrl();
            return result;
        }

    }

