//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.cssSelector;

public class NewWindow14 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
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
        Thread.sleep(2000);


        //2 перейти на страницу Countries
        driver.get("http://localhost/litecart/public_html/admin/?app=countries&doc=countries"); //переходим на страницу Countries
        Thread.sleep(2000);


        //3 выбрать страну и нажать Edit (нажать на карандаш)
        WebElement central_menu = driver.findElement(By.className("dataTable"));  //центральный блок на странице Countries
        List<WebElement> tdList = central_menu.findElements(cssSelector("tr")); //список веб элементов в верхнем меню на стр КаталогаList<WebElement> tdList = top_buttons.findElements(cssSelector("tr"));
        WebElement tr = tdList.get(tdList.size() - 1);

        tr.findElement(By.xpath("//a[contains(@href,'edit_country&country_code=AF')]"))
                .click(); //ищем кнопку Edit country, точнее ищем карандаш
        Thread.sleep(2000);


        //4 Edit Country Переход по внешним ссылкам
        WebElement content = driver.findElement(By.id("content"));
        List<WebElement> trList = content.findElements(cssSelector("tr"));// список ссылок на странице редактирования страны

        String originalWindow = driver.getWindowHandle();  //  запоминаем идентификатор текущего окна, он должен быть object или String????
      // запоминаем идентификаторы уже открытых окон
        Set<String> existingWindows = driver.getWindowHandles();//сет существующих окон

        for (int i = 1; i < 3; i++) {
            existingWindows = driver.getWindowHandles();
            //Внешняя ссылка для поля code alpha-2
            trList.get(i).findElement(By.tagName("a")).click(); //нажимаем на внешнюю ссылку
            String newWindow = wait.until(anyWindowOtherThan(existingWindows)); //ждем появления нового окна, с новым идентификатором
            driver.switchTo().window(newWindow); //переключаемся в новое окно
            Thread.sleep(2000);
            driver.close(); //закрываем его
            Thread.sleep(2000);
            driver.switchTo().window(originalWindow); //и возвращаемся в исходное окно
            Thread.sleep(2000);
        }




        List<WebElement> tr5 = trList.get(5).findElements(By.tagName("a"));// список ссылок на странице редактирования страны
        existingWindows = driver.getWindowHandles();
        tr5.get(0).click();
        Thread.sleep(2000);
        String newWindow = wait.until(anyWindowOtherThan(existingWindows)); //ждем появления нового окна, с новым идентификатором
        driver.switchTo().window(newWindow); //переключаемся в новое окно
        Thread.sleep(2000);
        driver.close(); //закрываем его
        Thread.sleep(2000);
        driver.switchTo().window(originalWindow); //и возвращаемся в исходное окно
        Thread.sleep(2000);

        List<WebElement> tr6 = trList.get(6).findElements(By.tagName("a"));// список ссылок на странице редактирования страны
        existingWindows = driver.getWindowHandles();
        tr6.get(1).click();
        Thread.sleep(2000);
        newWindow = wait.until(anyWindowOtherThan(existingWindows)); //ждем появления нового окна, с новым идентификатором
        driver.switchTo().window(newWindow); //переключаемся в новое окно
        Thread.sleep(2000);
        driver.close(); //закрываем его
        Thread.sleep(2000);
        driver.switchTo().window(originalWindow); //и возвращаемся в исходное окно
        Thread.sleep(2000);

        for (int i = 7; i < trList.size()-2; i++) {
            existingWindows = driver.getWindowHandles();
            //Внешняя ссылка для поля code alpha-2
            trList.get(i).findElement(By.tagName("a")).click(); //нажимаем на внешнюю ссылку
            Thread.sleep(2000);
            newWindow = wait.until(anyWindowOtherThan(existingWindows)); //ждем появления нового окна, с новым идентификатором
            driver.switchTo().window(newWindow); //переключаемся в новое окно
            Thread.sleep(2000);
            driver.close(); //закрываем его
            Thread.sleep(2000);
            driver.switchTo().window(originalWindow); //и возвращаемся в исходное окно
            Thread.sleep(2000);
        }


    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;

    }

}
