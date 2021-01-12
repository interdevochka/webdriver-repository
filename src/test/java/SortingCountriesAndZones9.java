//package

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SortingCountriesAndZones9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void MyFirstTest() {
        driver.get("http://localhost/litecart/public_html/admin/login.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("remember_me")).click();

        driver.findElement(By.name("login")).click();
/*
        //начался блок со странами
        driver.get("http://localhost/litecart/public_html/admin/?app=countries&doc=countries");
        WebElement countriesBlock = driver.findElement(By.name("countries_form"));
        //System.out.println("----------41----- " + countriesBlock.size());

        List<WebElement> rowList = countriesBlock.findElements(By.className("row"));
        List<String> countriesList = new ArrayList<String>();
        System.out.println("----------44----- " + rowList.size());
        for (int i = 0; i <rowList.size(); i++) {
            WebElement a = rowList.get(i).findElement(cssSelector("a"));
            String countryName = a.getText();
            countriesList.add(countryName);
            //System.out.println("----------54----- " + countryName);

            List<WebElement> tdList = rowList.get(i).findElements(cssSelector("td"));
            String zoneCount = tdList.get(5).getText();
            System.out.println("----------58----- " + zoneCount);
            int zoneNumber = Integer.parseInt (zoneCount); //что это значит?
            String zoneLink = a.getAttribute("href");


            // Начался второй блок с зонами
           if (zoneNumber!=0) {
                driver.get(zoneLink);
                WebElement task2Form = driver.findElement(By.name("geo_zones_form"));
                List<WebElement> task2RowList = task2Form.findElements(By.className("row"));
                for (int j = 0; j < task2RowList.size(); j++) {
                    List<WebElement> zonesList = task2Form.findElements(By.cssSelector("a"));
                    String zoneName = a.getText();
                    zonesList.add(zoneName);
                }
            }
        }

       boolean isSorted = countriesList.stream().sorted().collect(Collectors.toList()).equals(countriesList);
        System.out.println("----------62----- " + isSorted);

      //  for (int i = 0; i <countriesList.size(); i++) {
         //  System.out.println("----------55----- " + countriesList.get(i));

        }



    @After
    public void stop() {
        driver.quit();
        driver = null;
}

}
*/ } }