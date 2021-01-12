//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Comparison10 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    //public void start() {
    //driver = new ChromeDriver();
    // driver = new FirefoxDriver();
    // driver = new EdgeDriver();
    // wait = new WebDriverWait(driver, 10);

    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }


    @Test
    public void comparePages() throws InterruptedException {

        driver.get("http://localhost/litecart/public_html/en/");

        WebElement page1Campaings = driver.findElement(By.id("box-campaigns"));

        // Часть 1 -- Поиск на главной странице

        // а  Имя продукта
        WebElement name = page1Campaings.findElement(By.className("name"));
        String page1Name = name.getText();

        // б  Обычная цена и аукционная цена
        WebElement regular_price = page1Campaings.findElement(By.className("regular-price"));
        String page1NormalPrice = regular_price.getText();

        WebElement campaign_price = page1Campaings.findElement(By.className("campaign-price"));
        String page1AuktionPrice = campaign_price.getText();

        // обычной цены цвет шрифта
        WebElement regular_price_color = page1Campaings.findElement(By.className("regular-price"));
        String page1NormalPriceColor = regular_price_color.getCssValue("color");

        // у обычной цены ---------зачеркнутая цена не работает!!!!!!!!
        WebElement regular_price_style = page1Campaings.findElement(By.className("regular-price"));
        String page1NormalPriceStyle = regular_price_style.getCssValue("s");

        // г  у аукционной цены цвет  и стиль   ----стиль выдает 700, а в devTools показывает 900
        WebElement auktion_price_Style = page1Campaings.findElement(By.className("campaign-price"));
        String page1AuktionPriceStyle = auktion_price_Style.getCssValue("font-weight");

        WebElement auktion_price_color = page1Campaings.findElement(By.className("campaign-price"));
        String page1AuktionPriceColor = auktion_price_color.getCssValue("color");

        // д  размер шрифта цены аукционной и обычной
        WebElement regular_price_font_size = page1Campaings.findElement(By.className("regular-price"));
        String page1NormalPriceSize = regular_price_font_size.getCssValue("font-size");

        WebElement auktion_price_font_size = page1Campaings.findElement(By.className("campaign-price"));
        String page1AuktionPriceSize = auktion_price_font_size.getCssValue("font-size");


        System.out.println("page1Name = " + page1Name);
        System.out.println("page1NormalPrice = " + page1NormalPrice);
        System.out.println("page1AuktionPrice = " + page1AuktionPrice);
        System.out.println("page1NormalPriceStyle = " + page1NormalPriceStyle);
        System.out.println("page1NormalPriceColor = " + page1NormalPriceColor);
        System.out.println("page1AuktionPriceStyle = " + page1AuktionPriceStyle);
        System.out.println("page1AuktionPriceColor = " + page1AuktionPriceColor);
        System.out.println("page1NormalPriceSize = " + page1NormalPriceSize);
        System.out.println("page1AuktionPriceSize = " + page1AuktionPriceSize);


        // Часть 2 -- Поиск на странице товара
        driver.get("http://localhost/litecart/public_html/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");
        WebElement page2Campaings = driver.findElement(By.id("box-product"));

        // а Имя продукта
        WebElement name2 = page2Campaings.findElement(By.className("title"));
        String page2Name = name2.getText();

        // б Обычная цена и аукционная цена
        WebElement regular_price2 = page2Campaings.findElement(By.className("regular-price"));
        String page2NormalPrice = regular_price2.getText();

        WebElement campaign_price2 = page2Campaings.findElement(By.className("campaign-price"));
        String page2AuktionPrice = campaign_price2.getText();

        // у обычной цены цвет шрифта
        WebElement regular_price_page2_color = page2Campaings.findElement(By.className("regular-price"));
        String page2NormalPriceColor = regular_price_page2_color.getCssValue("color");

        // у обычной цены ---------зачеркнутая цена не работает!!!!!!!!
        WebElement regular_price_page2_style = page2Campaings.findElement(By.className("regular-price"));
        String page2NormalPriceStyle = regular_price_page2_style.getCssValue("s");

        // г  у аукционной цены цвет  и стиль
        WebElement auktion_price_page2_Style = page2Campaings.findElement(By.className("campaign-price"));
        String page2AuktionPriceStyle = auktion_price_page2_Style.getCssValue("font-weight");

        WebElement auktion_price_page2_color = page2Campaings.findElement(By.className("campaign-price"));
        String page2AuktionPriceColor = auktion_price_page2_color.getCssValue("color");

        // д  размер шрифта цены аукционной и обычной
        WebElement regular_price_page2_font_size = page2Campaings.findElement(By.className("regular-price"));
        String page2NormalPriceSize = regular_price_page2_font_size.getCssValue("font-size");

        WebElement auktion_price_page2_font_size = page2Campaings.findElement(By.className("campaign-price"));
        String page2AuktionPriceSize = auktion_price_page2_font_size.getCssValue("font-size");


        System.out.println("page2Name = " + page2Name);
        System.out.println("page2NormalPrice = " + page2NormalPrice);
        System.out.println("page2AuktionPrice = " + page2AuktionPrice);
        System.out.println("page2NormalPriceStyle = " + page2NormalPriceStyle);
        System.out.println("page2NormalPriceColor = " + page2NormalPriceColor);
        System.out.println("page2AuktionPriceStyle = " + page2AuktionPriceStyle);
        System.out.println("page2AuktionPriceColor = " + page2AuktionPriceColor);
        System.out.println("page2NormalPriceSize = " + page2NormalPriceSize);
        System.out.println("page2AuktionPriceSize = " + page2AuktionPriceSize);


        // Часть 3 -- Сравнение
        if (!page1Name.equals(page2Name)) {
            throw new InterruptedException("Названия продукта не идентичны");
        }
        if (!page1NormalPrice.equals(page2NormalPrice)) {
            throw new InterruptedException("Обычные цены не идентичны");
        }
        if (!page1AuktionPrice.equals(page2AuktionPrice)) {
            throw new InterruptedException("Аукционные цены не идентичны");
        }

        if (!page1NormalPriceStyle.equals(page2NormalPriceStyle)) {
            throw new InterruptedException("Стили обычных цен не идентичны");
        }

        /*
        if (!page1NormalPriceColor.equals(page2NormalPriceColor)) {
            throw new InterruptedException("Цвета обычных цен не идентичны");
        }

        if (!page1AuktionPriceStyle.equals(page2AuktionPriceStyle)) {
            throw new InterruptedException("Стили аукционных цен не идентичны");
        }

        if (!page1AuktionPriceColor.equals(page2AuktionPriceColor)) {
            throw new InterruptedException("Цвета аукционных цен не идентичны");
        }

        if (!page1NormalPriceSize.equals(page2NormalPriceSize)) {
            throw new InterruptedException("Размеры обычных цен не идентичны");
        }

        if (!page1AuktionPriceSize.equals(page2AuktionPriceSize)) {
            throw new InterruptedException("Размеры аукционных цен не идентичны");
        }


        /*
        if( ! page1AuktionPrice.equals(page2AuktionPrice)) {
            throw new InterruptedException("Названия продукта не идентичны");
        }
        */

        page1NormalPriceColor = "rgba(119, 119, 119, 1)";

        String cut1 = page1NormalPriceColor.substring(5, 8);
        String cut2 = page1NormalPriceColor.substring(10, 13);
        String cut3 = page1NormalPriceColor.substring(15, 18);
        System.out.println(cut1);
        System.out.println(cut2);
        System.out.println(cut3);
/*
        if(! (r==g==b)) {
            throw new InterruptedException("Названия продукта не идентичны");
        }
*/




       /*
        WebElement form = driver.findElement(By.name("countries_form"));
        List<WebElement> trClassRowList = form.findElements(By.className("row"));

        */

    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}