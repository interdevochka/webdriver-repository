//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StickersAvailability8 {

    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void StickersTest() throws Exception {

        driver.get("http://localhost/litecart/en/");

        // Шаг 1. Находим блок всех товаров (уток)
        WebElement middle = driver.findElement(By.className("middle"));

        WebElement webElement;

        // Шаг 2. Находим блок раздела Most Popular
        webElement = middle.findElement(By.id("box-most-popular"));
        stickersAmountCheck(webElement);

        // Шаг 3. Находим блок раздела Campaigns
        webElement = middle.findElement(By.id("box-campaigns"));
        stickersAmountCheck(webElement);

        // Шаг 4. Находим блок раздела Latest Products
        webElement = middle.findElement(By.id("box-latest-products"));
        stickersAmountCheck(webElement);

    }


    private void stickersAmountCheck(WebElement webElement) throws Exception {

        // Создаём список товаров (уток) для текущего раздела
        List<WebElement> allDucks = webElement.findElements(By.className("image-wrapper"));
        System.out.println("allDucks.size() = " + allDucks.size());

        // В цикле проверяем Количество стикеров для каждой отдельной утки из списка
        for (WebElement nextElement : allDucks) {
            List<WebElement> amountStickersPerOneProduct = nextElement.findElements(By.className("sticker"));
            if (amountStickersPerOneProduct.size() != 1) {
                throw new Exception("У продукта не ровно один стикер");
            }
        }

    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}