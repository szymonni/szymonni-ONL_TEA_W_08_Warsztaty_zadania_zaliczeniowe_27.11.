package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Zadanie1Steps {

    private WebDriver driver;

    @Given("^Open in browser mystore-testlab.coderslab.pl$")
    public void openStore() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
    }

    @When("click on botton Sign in")
    public void clickSignIn() {
        driver.findElement(By.id("_desktop_user_info")).click();
    }

    @When("^entering (.*) in Email input$")
    public void enterEmail(String keyword) {
        WebElement element = driver.findElement(By.name("email"));
        element.click();
        element.sendKeys(keyword);
    }

    @When("^entering (.*) in Password input$")
    public void enterPassword(String keyword) {
        WebElement element = driver.findElement(By.name("password"));
        element.click();
        element.sendKeys(keyword);
    }

    @And("click on button Sign in to log in the site")
    public void clickSignIn2() {
        driver.findElement(By.id("submit-login")).click();
    }

    @When("click on button Addresses")
    public void clickAddresses() {
        driver.findElement(By.cssSelector("[title*='Addresses']")).click();
    }

    @When("click on button + Create new address")
    public void clickCreateNewAddress() {
        driver.findElement(By.xpath("//span[.='Create new address']")).click();
    }

    @And("^entering (.*) in Alias input$")
    public void enterAlias(String keyword) {
        WebElement element = driver.findElement(By.name("alias"));
        element.click();
        element.sendKeys(keyword);
    }

    @And("^entering (.*) in Address input$")
    public void enterAddress(String keyword) {
        WebElement element = driver.findElement(By.name("address1"));
        element.click();
        element.sendKeys(keyword);
    }

    @And("^entering (.*) in Zip input$")
    public void enterZip(String keyword) {
        WebElement element = driver.findElement(By.name("postcode"));
        element.click();
        element.sendKeys(keyword);
    }

    @And("^entering (.*) in City input$")
    public void enterCity(String keyword) {
        WebElement element = driver.findElement(By.name("city"));
        element.click();
        element.sendKeys(keyword);
    }

    @And("choose Country on select list")
    public void selectCountry() {
        Select dropdown = new Select(driver.findElement(By.name("id_country")));
        dropdown.selectByVisibleText("United Kingdom");

    }

    @And("^entering (.*) in Phone input$")
    public void enterPhone(String keyword) {
        WebElement element = driver.findElement(By.name("phone"));
        element.click();
        element.sendKeys(keyword);

    }

    @And("click on button Save")
    public void clickSave() {
        driver.findElement(By.className("btn-primary")).click();
    }

    @Then("address successfully added")
    public void addedAddress() {
        WebElement successMsg = driver.findElement(By.className("alert-success"));
        Assert.assertEquals("Address successfully added!", successMsg.getText());
    }

    @Then("^checking form address (.*), (.*), (.*), (.*) and (.*)$")
    public void checkAddress(String alias, String address, String city, String postcode, String phone) {
        String user = "Szymon Test";
        String country = "United Kingdom";
        String expectedValue = alias + "\n" + user + "\n" + address + "\n"  + city + "\n" + postcode + "\n" + country + "\n" + phone;
        String comparisonValue = driver.findElement(By.className("address-body")).getText();
        Assert.assertEquals(expectedValue, comparisonValue);
    }

    @And("closed browser")
    public void closeBrowser() {
        driver.quit();
    }

}