//package ru.stqa.training.selenium;//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.cssSelector;


public class SortingCountriesAndZones9V3 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void MyFirstTest() throws InterruptedException {

        List<String> countriesList1 = new ArrayList<String>();
        List<String> zonesList2 = new ArrayList<>();
        List<String> geoZonesList1 = new ArrayList<>();
        List<String> editGeoZonesList2 = new ArrayList<>();


        //залогиниться
        driver.get("http://localhost/litecart/public_html/admin/login.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("remember_me")).click();

        driver.findElement(By.name("login")).click();


        //1. начался блок со странами
        driver.get("http://localhost/litecart/public_html/admin/?app=countries&doc=countries"); //зайти на страницу стран
        WebElement countriesBlock = driver.findElement(By.name("countries_form"));
        WebElement table = countriesBlock.findElement(By.tagName("table"));
        WebElement tbody0 = table.findElement(By.tagName("tbody"));
        List<WebElement> trList0 = tbody0.findElements(By.tagName("tr"));

        //a   проверка, что страны расположены в алфавитном порядке
        for (int i = 1; i < trList0.size() - 1; i++) {

            System.out.println("--- 56 ------ i = " + i);
            // Сохраняем все страны в список

            List<WebElement> tdListCountry = trList0.get(i).findElements(By.tagName("td"));
            WebElement td4 = tdListCountry.get(4);
            WebElement a = td4.findElement(By.tagName("a"));
            String countryName = a.getText();
            countriesList1.add(countryName);

            // Получаем число из колонки Zones
            List<WebElement> tdList = trList0.get(i).findElements(By.cssSelector("td"));
            String zoneCount = tdList.get(5).getText();

            if (!zoneCount.equals("0")) {
                // Получаем ссылку href
                String zoneLink = a.getAttribute("href");

                driver.get(zoneLink);

                WebElement task2Form = driver.findElement(By.id("table-zones"));
                WebElement tbody = task2Form.findElement(By.tagName("tbody"));
                List<WebElement> trList = tbody.findElements(By.tagName("tr"));

                for (int j = 1; j < trList.size() - 1; j++) {
                    List<WebElement> tdListZone = trList.get(j).findElements(By.tagName("td"));
                    zonesList2.add(tdListZone.get(2).getText());
                }
                boolean isSorted2 = zonesList2.stream().sorted().collect(Collectors.toList()).equals(zonesList2);
                if (isSorted2) {
                    System.out.println("Список зон страны отсортирован");
                } else {
                    System.out.println("Список зон страны не отсортирован");
                }
                zonesList2 = new ArrayList<>();
                driver.get("http://localhost/litecart/public_html/admin/?app=countries&doc=countries"); //зайти на страницу стран
                countriesBlock = driver.findElement(By.name("countries_form"));
                table = countriesBlock.findElement(By.tagName("table"));
                tbody0 = table.findElement(By.tagName("tbody"));
                trList0 = tbody0.findElements(By.tagName("tr"));

            } // End if


        } // End loop


        boolean isSorted = countriesList1.stream().sorted().collect(Collectors.toList()).equals(countriesList1);
        if (isSorted) {
            System.out.println("Список стран отсортирован");
        } else {
            System.out.println("Список стран не отсортирован");
        }


        ///////////////////////////////////////////////////
        //2)//зайти в каждую из стран и проверить, что зоны расположены в алфавитном порядке
        String countryName = "";
        driver.get("http://localhost/litecart/public_html/admin/?app=geo_zones&doc=geo_zones");
        WebElement task2Form = driver.findElement(By.name("geo_zones_form"));
        List<WebElement> task2RowList = task2Form.findElements(By.className("row"));

        String task2CountryName = "";
        List<WebElement> task2tdList;
        List<String> task2listCountries = new ArrayList<>();
        WebElement task2a;
        WebElement task2td3;
        String task2zoneCount;
        String task2link;

        for (int i = 0; i < task2RowList.size(); i++) {
            task2a = task2RowList.get(i).findElement(cssSelector("a"));
            task2CountryName = task2a.getText();
            if (!countryName.equals("")) {
                task2listCountries.add(task2CountryName);
            }
            task2tdList = task2RowList.get(i).findElements(cssSelector("td"));
            task2td3 = task2tdList.get(2);
            task2zoneCount = task2td3.getText();
            if (!task2zoneCount.equals("0")) {
                task2link = task2a.getAttribute("href");
                zoneCheckTask2(task2link);

                driver.get("http://localhost/litecart/public_html/admin/?app=geo_zones&doc=geo_zones");
                task2Form = driver.findElement(By.name("geo_zones_form"));
                task2RowList = task2Form.findElements(By.className("row"));
            }
        }

    }

    private boolean zoneCheck(String link) throws InterruptedException {
        driver.get(link);
        WebElement form = driver.findElement(By.id("table-zones"));
        List<WebElement> aLists = form.findElements(cssSelector("a"));
        // System.out.println("aLists.size() = " + aLists.size());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < aLists.size(); i++) {
            if (aLists.get(i).getText() != "") {
                list.add(aLists.get(i).getText());
                System.out.println(aLists.get(i).getText());
            }
        }
        boolean isSorted = list.stream().sorted().collect(Collectors.toList()).equals(list);
        if (!isSorted) {
            throw new InterruptedException("Список зон не отсортирован");
        }
        System.out.println("Список зон отсортирован");
        return isSorted;
    }


    private boolean zoneCheckTask2(String link) throws InterruptedException {
        System.out.println("link = " + link);
        boolean isSorted = true;
        driver.get(link);
        WebElement form = driver.findElement(By.id("table-zones"));
        List<WebElement> trList = form.findElements(cssSelector("tr"));
        List<String> selectedList = new ArrayList<>();

        boolean bo = isElementPresent(driver, By.cssSelector("select[disabled='disabled']"));
        if (bo) {
            return true;
        } else {
            for (int i = 1; i < trList.size() - 1; i++) {
                List<WebElement> tdList = trList.get(i).findElements(cssSelector("td"));
                WebElement select = tdList.get(2).findElement(By.cssSelector("select"));
                WebElement selected = select.findElement(By.cssSelector("option[selected='selected']"));
                selectedList.add(selected.getText());
            }
        }
        isSorted = selectedList.stream().sorted().collect(Collectors.toList()).equals(selectedList);
        if (!isSorted) {
            throw new InterruptedException("Список зон в задании 2 не отсортирован");
        }
        System.out.println("Список зон в задании 2 отсортирован");
        return isSorted;
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }



    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

