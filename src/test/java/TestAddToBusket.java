import org.junit.Assert;
import org.junit.Test;

public class TestAddToBusket extends Settings {
    //добавление товаров в корзину, сравнение товара в корзине с карточкой товара
    String baseUrlMain = "https://www.amazon.com";

    @Test //добавление в корзину одного товара, сравнение в корзине с карточкой товара, та ли сумма и кол-во
    public void testAddToCartOneDress() throws InterruptedException {
        addToBusketPage.open(baseUrlMain);
        addToBusketPage.findDress();
        addToBusketPage.findConcreticDress();
        String findDressSizeResult = addToBusketPage.findDressSizeResult();  //запоминаем размер в карточке товара
        addToBusketPage.chooseDressSizeMedium();  //выбрать размер Medium в карточке товара
        String findDressColorResult = addToBusketPage.findDressColorResult(); //запоминаем цвет в карточке товара
        addToBusketPage.chooseDressColorNavy(); //выбрать цвет
        String findDressNameResult = addToBusketPage.findDressNameResult(); //запоминаем название платья в карточке товара
        String findDressPriceResult = addToBusketPage.findDressPriceResult(); //запоминаем цену в карточке товара
        String findOneDressResult = addToBusketPage.findOneDressResult(); //запоминаем кол-во платьев 1
        addToBusketPage.addToCartButton(); //нажать кнопку "Add to Cart"
        addToBusketPage.pressBusketButton(); //перейти в корзину, нажать на иконку корзины
        String[] array = addToBusketPage.findDressColorResultInBusket();
        System.out.println(array[1]);
        Assert.assertEquals(findDressNameResult, array[0].trim()); //Берем из массива первый параметр (до запятой)-название, обрезаем пробелы, сравниваем с тем, что было в карточке платья
        Assert.assertEquals(findDressColorResult, array[1].trim()); //Берем из массива второй параметр, цвет, обрезаем пробелы, сравниваем с тем, что было в карточке платья
        Assert.assertEquals(findDressSizeResult, array[2].trim());//Берем из массива третий параметр, размер М, обрезаем пробелы, сравниваем с тем, что было в карточке платья
    }

    }

