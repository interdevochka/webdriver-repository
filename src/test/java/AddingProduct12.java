package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class AddingProduct12 {
    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void add() throws InterruptedException {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("remember_me")).click();

        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        Thread.sleep(2000);

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog"); //переходим на страницу Каталога
        Thread.sleep(2000);


        WebElement top_buttons = driver.findElement(By.id("content"));  //все меню на странице Каталога
        List<WebElement> tdList = top_buttons.findElements(cssSelector("tr")); //список веб элементов в верхнем меню на стр КаталогаList<WebElement> tdList = top_buttons.findElements(cssSelector("tr"));
        WebElement tr = tdList.get(tdList.size() - 1);

        // Объединили 2 строки в одну
/*
        WebElement add_new_product = tr.findElement(By.xpath("//a[contains(@href,'?category_id=0&app=catalog&doc=edit_product')]"));  //ищем кнопку Add New Product в верхнем меню, на стр Каталога
        add_new_product.click();
*/
        tr.findElement(By.xpath("//a[contains(@href,'?category_id=0&app=catalog&doc=edit_product')]")).click(); //ищем кнопку Add New Product в верхнем меню, на стр Каталога


        Thread.sleep(2000);


        //вкладка General
        WebElement general_menu_catalog = driver.findElement(By.id("content")); // центральный блок на странице Каталога


        //нажатие радиобаттона КАК??????


        WebElement name = general_menu_catalog.findElement(By.name("name[en]")); //заполняем поле Name
        name.sendKeys("Vasya");

        WebElement code = general_menu_catalog.findElement(By.name("code")); //заполняем поле Code
        code.sendKeys("12345");
        Thread.sleep(2000);

        //нажатие Categories КАК??????

        //нажатие Product Groups КАК??????


        WebElement quantity = general_menu_catalog.findElement(By.cssSelector("input[name='quantity']"));// заполняем поле Quantity
        quantity.clear();
        quantity.sendKeys("5");
        Thread.sleep(2000);

        //нажатие Upload Images КАК???
        WebElement uploadImages = driver.findElement(By.cssSelector("input[name='new_images[]']"));
        uploadImages.sendKeys("C:\\Users\\HP\\Desktop");
        //uploadImages.sendKeys("duck.jpg"); // TODO
        Thread.sleep(2000);


        //заполнить календарик Date Valid From
        WebElement kalendar1 = driver.findElement(By.cssSelector("input[name='date_valid_from']"));
        kalendar1.clear();
        kalendar1.sendKeys("16.01.2021");
        Thread.sleep(4000);


        //заполнить календарик Date Valid To
        WebElement kalendar2 = driver.findElement(By.cssSelector("input[name='date_valid_to']"));
        kalendar2.clear();
        kalendar2.sendKeys("22.01.2021");
        Thread.sleep(4000);

        //переключиться на вкладку INFORMATION

        WebElement information = general_menu_catalog.findElement(By.xpath("//a[contains(@href,'#tab-information')]"));  //ищем вкладку Information
        information.click();
        Thread.sleep(2000);


        WebElement manufacturer = general_menu_catalog.findElement(By.cssSelector("select[name='manufacturer_id']"));  //дропдаун меню Manufacturer
        manufacturer.click();
        Select select = new Select(manufacturer);
        select.selectByVisibleText("ACME Corp.");
        manufacturer.click();
        Thread.sleep(2000);

        WebElement keywords = general_menu_catalog.findElement(By.cssSelector("input[name='keywords']")); //заполняем поле keywords
        keywords.sendKeys("train");
        Thread.sleep(2000);

        WebElement short_description = general_menu_catalog.findElement(By.cssSelector("input[name='short_description[en]']")); //заполняем поле short description
        short_description.sendKeys("little train toy");
        Thread.sleep(2000);


        WebElement description = general_menu_catalog.findElement(By.cssSelector("div[class='trumbowyg-editor']")); //заполняем поле short description
        description.sendKeys("Its a little train toy");
        Thread.sleep(2000);


        WebElement head_title = general_menu_catalog.findElement(By.cssSelector("input[name='head_title[en]']")); //заполняем поле Head Title
        head_title.sendKeys("Plastic train");
        Thread.sleep(2000);

        WebElement meta_description = general_menu_catalog.findElement(By.cssSelector("input[name='meta_description[en]']")); //заполняем поле Meta Description
        meta_description.sendKeys("none");
        Thread.sleep(2000);

//переход на вкладку Prices
        WebElement prices = general_menu_catalog.findElement(By.xpath("//a[contains(@href,'#tab-prices')]"));  //ищем вкладку Information
        prices.click();
        Thread.sleep(2000);

        WebElement purchase_price = general_menu_catalog.findElement(By.cssSelector("input[name='purchase_price']"));// заполняем поле Purchase Price
        purchase_price.clear();
        purchase_price.sendKeys("10");
        Thread.sleep(1000);

        WebElement valuta = driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")); //выбираем вид валюты в дропдаун меню
        valuta.click();
        Select select1 = new Select(valuta);
        Thread.sleep(1000);
        select1.selectByVisibleText("US Dollars");

        WebElement tax = general_menu_catalog.findElement(By.cssSelector("input[name='gross_prices[USD]']"));// заполняем Price Incl. Tax (?)
        tax.clear();
        tax.sendKeys("8");
        Thread.sleep(2000);


        WebElement tax2 = general_menu_catalog.findElement(By.cssSelector("input[name='gross_prices[EUR]']"));// заполняем Price Incl. Tax (?)
        tax2.clear();
        tax2.sendKeys("6");
        Thread.sleep(2000);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;

    }

}
