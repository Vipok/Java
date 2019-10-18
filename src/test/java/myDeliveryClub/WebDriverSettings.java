package myDeliveryClub;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSettings {
    public ChromeDriver driver;

    //@Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1900,1000");
        System.setProperty("webdriver.chrome.driver", "J:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
    }

    /*@After
    public void close() {
        driver.quit();//для закрытия браузера
    }*/
}
