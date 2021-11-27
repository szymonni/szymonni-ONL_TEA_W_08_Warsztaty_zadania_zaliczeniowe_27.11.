package pl.coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.Zadanie2Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Zadanie2Test {

    private WebDriver driver;

    @Before
    public void openStore() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
    }

    @Test
    public void order() throws IOException {
        Zadanie2Page zadanie2Page = new Zadanie2Page(driver);
        zadanie2Page.signIn("xytjawcrqdjqonhmqi@mrvpm.net", "Test1234!");
        zadanie2Page.buyOrder("5");
        zadanie2Page.getscreenshot();
    }


//    @After
//    public void tearDown() {
//        driver.quit();
//    }


}
