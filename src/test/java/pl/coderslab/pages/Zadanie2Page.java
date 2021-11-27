package pl.coderslab.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class Zadanie2Page {
    private WebDriver driver;

    public Zadanie2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String email, String password) {
        WebElement signInButton = driver.findElement(By.id("_desktop_user_info"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.click();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement logInButton = driver.findElement(By.id("submit-login"));
        logInButton.click();

    }

    public void buyOrder(String number) {

        WebElement logo = driver.findElement(By.id("_desktop_logo"));
        logo.click();

        WebElement pickArticle = driver.findElement(By.xpath("(//article[@class='product-miniature js-product-miniature'])[2]"));
        pickArticle.click();

        Select dropdown = new Select(driver.findElement(By.name("group[1]")));
        dropdown.selectByVisibleText("M");

        WebElement quantity = driver.findElement(By.name("qty"));
        quantity.clear();
        quantity.click();
        quantity.sendKeys(number);
        quantity.sendKeys(Keys.ENTER);

        WebElement checkout = driver.findElement(By.xpath("//*[contains(text(), 'Proceed to checkout')]"));
        checkout.click();

        WebElement checkout2 = driver.findElement(By.xpath("//*[contains(text(), 'Proceed to checkout')]"));
        checkout2.click();

        WebElement confirmAddresses = driver.findElement(By.name("confirm-addresses"));
        confirmAddresses.click();

        WebElement confirmDelivery = driver.findElement(By.name("confirmDeliveryOption"));
        confirmDelivery.click();

        WebElement payment = driver.findElement(By.id("payment-option-1"));
        payment.click();

        WebElement checkAgreement = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        checkAgreement.click();

        WebElement orderButton = driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']"));
        orderButton.click();

    }

    public void getscreenshot() throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("C:\\Users\\szymo\\Desktop\\CodersLab\\screenshots\\screenshot.png"));
    }

}
