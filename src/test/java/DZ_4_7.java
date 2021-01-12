//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class DZ_4_7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        // driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void loginAdmin() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);
        WebElement ul = driver.findElement(By.id("box-apps-menu"));
        List<WebElement> liLists = ul.findElements(cssSelector("li"));
        WebElement link;
        WebElement li;
        for (int i = 0; i <liLists.size() ; i++) {
            ul = driver.findElement(By.id("box-apps-menu"));
            liLists = ul.findElements(cssSelector("li"));
            link = liLists.get(i).findElement(By.className("name"));
            link.click();
            Thread.sleep(1000);

            ul = driver.findElement(By.id("box-apps-menu"));
            liLists = ul.findElements(cssSelector("li"));
            List<WebElement> ulInnerLists = liLists.get(i).findElements(cssSelector("ul"));
            if(ulInnerLists.size() > 0) {
                List<WebElement> liInnerLists = ulInnerLists.get(0).findElements(cssSelector("li"));

                for (int j = 0; j <liInnerLists.size() ; j++) {
                   ul = driver.findElement(By.id("box-apps-menu"));
                   liLists = ul.findElements(cssSelector("li"));
                   ulInnerLists = liLists.get(i).findElements(cssSelector("ul"));
                   liInnerLists = ulInnerLists.get(0).findElements(cssSelector("li"));

                   WebElement linkInner = liInnerLists.get(j).findElement(By.className("name"));
                   linkInner.click();
                   Thread.sleep(1000);
                   boolean hasH1 = checkH1();
               }
            }

            WebElement homeDiv = driver.findElement(By.className("header"));
            WebElement home = homeDiv.findElement(cssSelector("a[title=Home]"));
            WebElement iTag = home.findElement(cssSelector("i"));
            iTag.click();
            Thread.sleep(1000);
            boolean hasH1 = checkH1();
        }

    }

    private boolean checkH1() throws InterruptedException {
        WebElement ul = driver.findElement(By.id("content"));
        List<WebElement> h1Lists = ul.findElements(cssSelector("h1"));
        if(h1Lists.size() > 0) {
            return true;
        }
       return false;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}