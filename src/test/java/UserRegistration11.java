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
        public void rega() throws InterruptedException {

            String password = "root";
            String email = randomEmail();

            // Кликает по ссылке добавить нового пользователя
            driver.get("http://localhost/litecart/public_html/en/");
            WebElement leftBlock = driver.findElement(By.name("login_form"));
            List<WebElement> trList = leftBlock.findElements(cssSelector("tr"));
            WebElement tr = trList.get(trList.size()-1);
            WebElement a = tr.findElement(By.tagName("a"));
            a.click();
            Thread.sleep(2000);
            // next page
            WebElement create_account_block = driver.findElement(By.id("create-account"));  //Блок регистрации

            WebElement first_name = create_account_block.findElement(By.name("firstname"));
            first_name.sendKeys("Vasya"); //кликаем и заполняем поле first name

            WebElement last_name = create_account_block.findElement(By.name("lastname"));
            last_name.sendKeys("Pupkin"); //кликаем и заполняем поле last name


            WebElement address_1 = create_account_block.findElement(By.name("address1"));
            address_1.sendKeys("Avenue str. 10-2"); //кликаем и заполняем поле address1

            WebElement postcode = create_account_block.findElement(By.name("postcode"));
            postcode.sendKeys("12345"); //кликаем и заполняем поле postcode

            WebElement city = create_account_block.findElement(By.name("city"));
            city.sendKeys("Mobile"); //кликаем и заполняем поле city

            WebElement country = driver.findElement(By.className("select2-selection__arrow"));
            country.click();
            WebElement country2 = driver.findElement(By.className("select2-search__field"));
            country2.sendKeys("United States" + Keys.ENTER);

            WebElement zone = driver.findElement(By.cssSelector("select[name='zone_code']"));
            zone.click();
            Select select = new Select(zone);
            Thread.sleep(1000);
            select.selectByVisibleText("Alaska");

            WebElement emailField = create_account_block.findElement(By.cssSelector("input[name='email']"));
            emailField.sendKeys(email); //кликаем и заполняем поле email

            WebElement phone = create_account_block.findElement(By.cssSelector("input[name='phone']"));
            phone.clear();
            phone.sendKeys("323332233"); //кликаем и заполняем поле phone

            WebElement desired_password = create_account_block.findElement(By.name("password"));
            desired_password.sendKeys(password); //кликаем и заполняем поле desired password

            WebElement confirm_password = create_account_block.findElement(By.name("confirmed_password"));
            confirm_password.sendKeys(password); //кликаем и заполняем поле confirm password

            WebElement create_account_button = create_account_block.findElement(By.name("create_account"));
            create_account_button.click(); //кликаем по кнопке create account
            Thread.sleep(2000);

            // разлогиниться + переход на главную страницу
            WebElement link = driver.findElement(By.linkText("Logout"));
            link.click();
            Thread.sleep(2000);

            // заново залогиниться
            WebElement emailAddress = driver.findElement(By.name("email"));
            emailAddress.sendKeys(email);

            WebElement password_main_page = driver.findElement(By.cssSelector("input[name='password']"));
            password_main_page.clear();
            password_main_page.sendKeys(password + Keys.ENTER); //кликаем и заполняем password
            Thread.sleep(2000);

            // ещё раз разлогиниться
            WebElement finalOut = driver.findElement(By.linkText("Logout"));
            finalOut.click();

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
