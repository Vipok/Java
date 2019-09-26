package seleniumLessons.ru.deliveryClub;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://www.delivery-club.ru/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("«Delivery Club» — круглосуточная доставка из любимых ресторанов города"));

        WebElement searchField = driver.findElement(By.cssSelector("Город, улица, дом"));
        searchField.clear();
        searchField.sendKeys("Рязань, Татарская улица, 31");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement searchButton = driver.findElement(By.cssSelector("user-addr__submit sbm-btn"));
        searchButton.click();
    }
}
