

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

        // обычной цены зачеркнутая цена
        WebElement regular_price_style = page1Campaings.findElement(By.className("regular-price"));
        String page1NormalPriceStyle = regular_price_style.getTagName();

        // г  у аукционной цены цвет
        WebElement auktion_price_Style = page1Campaings.findElement(By.className("campaign-price"));
        //String page1AuktionPriceStyle = auktion_price_Style.getCssValue("font-weight");
        String page1AuktionPriceStyle = auktion_price_Style.getTagName();

        WebElement auktion_price_color = page1Campaings.findElement(By.className("campaign-price"));
        String page1AuktionPriceColor = auktion_price_color.getCssValue("color");

        // д  размер шрифта цены аукционной и обычной
        WebElement regular_price_font_size = page1Campaings.findElement(By.className("regular-price"));
        String page1NormalPriceSize = regular_price_font_size.getCssValue("font-size");

        WebElement auktion_price_font_size = page1Campaings.findElement(By.className("campaign-price"));
        String page1AuktionPriceSize = auktion_price_font_size.getCssValue("font-size");


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
        String page2AuktionPriceStyle = auktion_price_page2_Style.getTagName();

        WebElement auktion_price_page2_color = page2Campaings.findElement(By.className("campaign-price"));
        String page2AuktionPriceColor = auktion_price_page2_color.getCssValue("color");

        // д  размер шрифта цены аукционной и обычной
        WebElement regular_price_page2_font_size = page2Campaings.findElement(By.className("regular-price"));
        String page2NormalPriceSize = regular_price_page2_font_size.getCssValue("font-size");

        WebElement auktion_price_page2_font_size = page2Campaings.findElement(By.className("campaign-price"));
        String page2AuktionPriceSize = auktion_price_page2_font_size.getCssValue("font-size");


        // Часть 3 -- Сравнение
        if (!page1Name.equals(page2Name)) {
            throw new InterruptedException("1. Названия продукта не идентичны");
        }
        if (!page1NormalPrice.equals(page2NormalPrice)) {
            throw new InterruptedException("2. Обычные цены не идентичны");
        }
        if (!page1AuktionPrice.equals(page2AuktionPrice)) {
            throw new InterruptedException("3. Аукционные цены не идентичны");
        }

        if (!page1NormalPriceStyle.equals("s")) {
            throw new InterruptedException("4. Стили обычных цен не идентичны");
        }

        if (!page1AuktionPriceStyle.equals("strong")) {
            throw new InterruptedException("5. Стили аукционных цен не идентичны");
        }

        //  Color
        String cut1 = page1NormalPriceColor.substring(5, 8);
        String cut2 = page1NormalPriceColor.substring(10, 13);
        String cut3 = page1NormalPriceColor.substring(15, 18);
        if (!cut1.equals(cut2) && cut1.equals(cut3)) {
            throw new InterruptedException("6. Цвет не серый");
        }

        String cut4 = page2NormalPriceColor.substring(5, 8);
        String cut5 = page2NormalPriceColor.substring(10, 13);
        String cut6 = page2NormalPriceColor.substring(15, 18);
        if (!cut4.equals(cut5) && cut4.equals(cut6)) {
            throw new InterruptedException("7. Цвет не красный");
        }

        Integer price1Size = Integer.valueOf(page1NormalPriceSize.substring(0, 2));
        Integer price2Size = Integer.valueOf(page2NormalPriceSize.substring(0, 2));

        if (!(price2Size > price1Size)) {
            throw new InterruptedException("8. Размеры обычных цен не идентичны");
        }

        Integer price3Size = Integer.valueOf(page1AuktionPriceSize.substring(0, 2));
        Integer price4Size = Integer.valueOf(page2AuktionPriceSize.substring(0, 2));

        if (!(price4Size > price3Size)) {
            throw new InterruptedException("9. Размеры аукционных цен не идентичны");
        }


    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

