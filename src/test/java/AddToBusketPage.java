import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToBusketPage {
    WebDriver driver;
    WebDriverWait wait;

    public AddToBusketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open(String baseUrlMain) {

        driver.get(baseUrlMain);
    }

    //поиск платья
    public void findDress() {
        driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Amazon Essentials Women's Tank Maxi Dress");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click(); //нажать на кнопку поиска лупа
    }

    //выбираем конкретное платье и заходим в карточку платья
    public void findConcreticDress() throws InterruptedException {
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/71-78Bgq4QL._MCnd_AC_UL320_.jpg']")).click();
    }

    //запоминаем  размер (medium) ++++
    public String findDressSizeResult() {
        driver.findElement(By.xpath("//span[@class='a-dropdown-prompt' and contains(text(),'Select')]")).click();
        return driver.findElement(By.xpath("//li[@aria-labelledby='native_dropdown_selected_size_name_3']//a[@id='native_dropdown_selected_size_name_3']"))
                .getText();
    }

    //выбрать размер (medium) ++++
    public void chooseDressSizeMedium() {
        driver.findElement(By.xpath("//li[@aria-labelledby='native_dropdown_selected_size_name_3']//a[@id='native_dropdown_selected_size_name_3']"))
                .click();
    }

    //запоминаем цвет Black ++++
    public String findDressColorResult() {
        return driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/31vyJz22jTL._SX38_SY50_CR,0,0,38,50_.jpg']"))
                .getAttribute("alt");
    }

    //выбрать цвет Black++++
    public void chooseDressColorNavy() {
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/31vyJz22jTL._SX38_SY50_CR,0,0,38,50_.jpg']")).click();
    }

    //запоминаем название платья ++++
    public String findDressNameResult() {
        return (driver.findElement(By.xpath("//span[@id='productTitle']")).getText()).trim();
    }


    //запоминаем цену
    public String findDressPriceResult() {
        return driver.findElement(By.xpath("//span[@id='price_inside_buybox']")).getText();
    }


    //запоминаем кол-во платьев 1 +++
    public String findOneDressResult() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='a-button-text a-declarative'])[2]")).click();
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//a[@id='quantity_0']")).getText();
    }

    //нажать кнопку "Add to Cart" ++++
    public void addToCartButton() {
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }

    //перейти в корзину, нажать на иконку корзины ++++
    public void pressBusketButton() {
        driver.findElement(By.xpath("//div[@id='nav-cart-text-container']")).click();
    }

    //запоминаем кол-во платьев в корзине
    public String findOneDressResultInBusket() {
        return driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText();
    }

    //запоминаем в массиве и разбиваем название платья, цвет Black платья, размер в корзине на куски 0,1,2
    public String[] findDressColorResultInBusket() {
        String nameColorSize = driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
        return nameColorSize.split(",");

    }


    //функции для второго теста
    //поиск бутылки
    public void findBottle() { //+++
        driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Lifefactory 22-Ounce Active Flip Cap Glass Water Bottle");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click(); //нажать на кнопку поиска лупа
    }

    //поиск конкретной бутылки и вход в карточку товара +++
    public void findConcreticBottle() {
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/61R5-eNUf6L._AC_UL320_.jpg']")).click();
    }

    //запомнить название бутылки // Делаем стринг, а нам нужен double....как его сделать?
    public String[] getBottleNameText() {
        String getNameOzColor = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        return getNameOzColor.split(",");
    }

    //запомнить цену бутылки +++
    public double getBottlePriceText() {
        return Double.parseDouble(driver.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText().replace("$", ""));
    }


    //выбрать кол-во бутылок -две ++++
    public void getBottleQuantity() {
        driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click(); //нажать на дропдаун меню
        driver.findElement(By.xpath("//a[@id='quantity_1']")).click(); //выбираем 2
    }

    //запомнить кол-во бутылок -две +++
    public double getBottleQuantityText() {
        driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();  //кликаем на дропдаун меню
        return Double.parseDouble(driver.findElement(By.xpath("//a[@id='quantity_1']")).getText().replace("$", ""));
    }


    // нажать кнопку "Add to Cart" функция addToCartButton есть в первом тесте ++++

    // //перейти в корзину, нажать на иконку корзины функция public void pressBusketButton() есть в первом тесте ++++

    //запоминаем кол-во бутылок в корзине +++
    public double getBottleQuantityTextInBusket() {
        return Double.parseDouble(driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]")).getText().replace("$", ""));
    }

    //запоминаем цену бутылок в корзине +++
    public double getBottlePriceTextInBusket() {
        return Double.parseDouble(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")).getText().replace("$", ""));
    }


    //запоминаем в массиве название бутылок, oz, цвет в корзине массив 0,1,2
    public String[] getBottleNameOzColorInBusket() {
        String nameOzSize = driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
        return nameOzSize.split(",");

    }
}


