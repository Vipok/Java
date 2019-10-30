package myDeliveryClub;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class JapaneseMom extends WebDriverSettings {

    @Test
    public void kushac() {
        setUp();
        driver.get("https://www.delivery-club.ru/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("«Delivery Club» — круглосуточная доставка из любимых ресторанов города"));

        WebElement searchField = driver.findElement(By.xpath(".//*[@id = \"user-addr__input\"]"));
        searchField.clear();
        searchField.sendKeys("Рязань, Татарская улица, 31");

        WebElement searchButton = driver.findElement(By.xpath(".//*[text() = \"Найти рестораны\"]"));
        searchButton.click();
        WebElement searchButton2 = driver.findElement(By.xpath(".//*[text() = \"ЯпоноМама\"]"));
        searchButton2.click();
        WebElement searchButton3 = driver.findElement(By.xpath(".//*[text() = \"заказать\"]"));
        searchButton3.click();
        WebElement searchButton4 = driver.findElement(By.xpath(".//*[@id=\"popup\"]/div[2]/div[1]/div[5]/div/a"));
        searchButton4.click();
        WebElement searchButton5 = driver.findElement(By.xpath(".//*[@id=\"middle\"]/div[3]/a[2]"));
        searchButton5.click();
        WebElement searchField2 = driver.findElement(By.xpath(".//*[@id=\"popup\"]/div[2]/div[4]/form/div/div[2]/div[1]/div[1]/input[2]"));
        searchField2.sendKeys("9999999999");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement searchButton7 = driver.findElement(By.xpath(".//*[@id=\"popup\"]/div[2]/div[4]/form/div/div[2]/div[1]/a"));
        searchButton7.click();
        WebElement searchField3 = driver.findElement(By.xpath("//*[@id=\"authorization-app\"]/div/div/div[2]/div[2]/div/form/div/label/input"));
        searchField3.sendKeys("777");
    }
}