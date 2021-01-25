//package ru.stqa.training.selenium.vns;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basket19 {


    private WebDriver driver;
    private WebDriverWait wait;

    Basket19PageHome basket19PageHome = new Basket19PageHome();
    Basket19PageProduct basket19PageProduct = new Basket19PageProduct();
    Basket19PageBasket basket19PageBasket = new Basket19PageBasket();
    String url = "http://localhost/litecart/public_html/en/";

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void main() throws InterruptedException {

        String newUrl = basket19PageHome.select1duck(driver, url);
        basket19PageProduct.add3Ducks(driver, newUrl, 0);

        newUrl = basket19PageHome.select1duck(driver, url);
        basket19PageProduct.add3Ducks(driver, newUrl, 1);

        newUrl = basket19PageHome.select1duck(driver, url);
        basket19PageProduct.add3Ducks(driver, newUrl, 2);

        basket19PageBasket.allDucksDelete(driver, url);

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;

    }

}

