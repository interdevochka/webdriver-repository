//package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SortingCountriesAndZones9Copy {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }
/*
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
        driver.get("http://localhost/litecart/public_html/admin/?app=geo_zones&doc=geo_zones"); //зайти на страницу Гео Зон

        WebElement geoZonesBlock = driver.findElement(By.cssSelector("form[name='geo_zones_form'] table tr:nth-child(2)"));//блок Гео Зонс
        List<WebElement> geoTrList = geoZonesBlock.findElements(By.tagName("tr")); //лист tr

        for (int i = 1; i < geoTrList.size() - 1; i++) {

            List<WebElement> tdListGeoZones = geoTrList.get(i).findElements(By.tagName("td"));
            WebElement td3 = tdListGeoZones.get(2);
            WebElement a = td3.findElement(By.tagName("a"));
            String geoZoneName = a.getText();
            geoZonesList1.add(geoZoneName);

            String geoZoneLink = a.getAttribute("href");

            driver.get(geoZoneLink);

            for (int j = 1; j < editGeoZonesList2.size(); j++) {

            WebElement editGeoZonesBlock = driver.findElement(By.cssSelector("form[name='geo_zones_form'] table tr:nth-child(2)"));//блок Зонс в Edit Geo Zones
            editGeoZonesList2.add(editGeoZonesBlock.getCssValue(By.name("zones[1][zone_code]")).getText());

            }
            boolean isSorted3 = editGeoZonesList2.stream().sorted().collect(Collectors.toList()).equals(editGeoZonesList2);
            if (isSorted3) {
                System.out.println("Зоны отсортированы");
            } else {
                System.out.println("Зоны не отсортированы");
            }

            editGeoZonesList2 = new ArrayList<>();
            driver.get("http://localhost/litecart/public_html/admin/?app=geo_zones&doc=geo_zones"); //зайти на страницу Гео Зон
            WebElement geoZonesBlock1 = driver.findElement(By.cssSelector("form[name='geo_zones_form'] table tr:nth-child(2)"));//блок Гео Зонс
            List<WebElement> geoTrList1 = geoZonesBlock1.findElements(By.tagName("tr")); //лист tr

        }
    }
        //второй tr и третий td  name = zones[1][zone_code]

        //

    // End method MyFirstTest

*/

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

