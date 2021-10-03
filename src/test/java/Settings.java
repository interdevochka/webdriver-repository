import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Settings {
    public WebDriver driver;
    public WebDriverWait wait;
   // public AmazonPage amazonPage;
   // public PurpleHeadphonesPage purpleHeadphonesPage;
  //  public MainPage mainPage;
    public AddToBusketPage addToBusketPage;
   // public FilterPage filterPage;
   // public RegistrationPage registrationPage;
   // public PaginationPage paginationPage;
   // public AuthorizationPage authorizationPage;

    @Before
    public void before() {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\M6800\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // amazonPage = new AmazonPage(driver);
       // purpleHeadphonesPage = new PurpleHeadphonesPage(driver);
       // mainPage = new MainPage(driver);
        addToBusketPage = new AddToBusketPage(driver);
       // filterPage = new FilterPage(driver);
       // registrationPage = new RegistrationPage(driver);
      //  paginationPage = new PaginationPage(driver);
       // authorizationPage = new AuthorizationPage(driver);
    }

    @After
    public void close() {
        driver.quit();
    }
}
