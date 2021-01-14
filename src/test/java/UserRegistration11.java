//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class UserRegistration11 {

        private WebDriver driver;
        private WebDriverWait wait;


        @Before
        public void start() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 3);
        }

        @Test
        public void registration() throws InterruptedException {

            String password = "root";
            String email = randomEmail();


            driver.get("http://localhost/litecart/en/");
            WebElement leftBlock = driver.findElement(By.name("login_form"));
            List<WebElement> trList = leftBlock.findElements(cssSelector("tr"));
            WebElement tr = trList.get(trList.size()-1);
            WebElement a = tr.findElement(By.name("a"));
            a.click();

            // next page
            WebElement create_account_block = driver.findElement(By.className("content"));  //Блок регистрации

            WebElement first_name = create_account_block.findElement(By.name("firstname"));
            first_name.sendKeys("Vasya"); //кликаем и заполняем поле first name

            WebElement last_name = create_account_block.findElement(By.name("lastname"));
            last_name.sendKeys("Pupkin"); //кликаем и заполняем поле last name

            WebElement address_1 = create_account_block.findElement(By.name("address1"));
            address_1.sendKeys("Avenue str. 10-2"); //кликаем и заполняем поле address1

            WebElement postcode = create_account_block.findElement(By.name("postcode"));
            postcode.sendKeys("12345"); //кликаем и заполняем поле address1

            WebElement city = create_account_block.findElement(By.name("city"));
            city.sendKeys("Mobile"); //кликаем и заполняем поле city

            WebElement country = create_account_block.findElement(By.id("select2-country_code-nw-container"));
            country.click();
            country.sendKeys("United States"+ Keys.ENTER); //кликаем на выпадающий список  и прописываем в поле country Unated States

            WebElement zone = driver.findElement(By.name("zone_code"));
            Select select = new Select(zone);
            select.selectByVisibleText("Alabama");

            WebElement phone = create_account_block.findElement(By.id("phone"));
            phone.clear();
            phone.sendKeys("323332233"); //кликаем и заполняем поле phone


            WebElement create_account_button = create_account_block.findElement(By.name("create_account"));
            create_account_button.click(); //кликаем по кнопке create account








        }

        private String randomEmail() {
            Random rand = new Random();
            int f = rand.nextInt(5000); ;
            String mail = f + "user" + f + "@mail.ru";
            String result = mail;
            return result;
        }

            @After
            public void stop () {
                driver.quit();
                driver = null;

    }

}
