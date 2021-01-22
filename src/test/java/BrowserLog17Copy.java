//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class BrowserLog17Copy {

    private WebDriver driver;
    WebElement idContent;
    WebElement catalog_central_menu;
    List<WebElement> trList;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void newWindow() throws InterruptedException {

        //1 логинимся на админку
        driver.get("http://localhost/litecart/public_html/admin/");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("remember_me")).click();

        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);

        //2 открыть категорию Catalog, которая содержит товары
        driver.get("http://localhost/litecart/public_html/admin/?app=catalog&doc=catalog&category_id=1"); //переходим на страницу Catalog
        Thread.sleep(1000);

        // form  name="catalog_form  это общий блок
        getTrList();
        catalog_central_menu.findElement(By.xpath("//a[contains(@href,'category_id=2')]"))
                .click();
        getTrList();
        Thread.sleep(1000);

        for (int i = 4; i < trList.size() - 1; i++) {
            trList.get(i).findElement(By.tagName("a")).click();
            Thread.sleep(10000);
            driver.get("http://localhost/litecart/public_html/admin/?app=catalog&doc=catalog&category_id=1"); //переходим на страницу Catalog
            Thread.sleep(1000);
            getTrList();
            catalog_central_menu.findElement(By.xpath("//a[contains(@href,'category_id=2')]"))
                    .click();
            Thread.sleep(1000);
            getTrList();
            Thread.sleep(1000);
        }

        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l);
        }
    }

    private void getTrList() {
        idContent = driver.findElement(By.id("content"));
        catalog_central_menu = idContent.findElement(By.name("catalog_form"));
        trList = catalog_central_menu.findElements(cssSelector("tr")); //список веб элементов в верхнем меню на стр КаталогаList<WebElement> tdList = top_buttons.findElements(cssSelector("tr"));

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;

    }

}