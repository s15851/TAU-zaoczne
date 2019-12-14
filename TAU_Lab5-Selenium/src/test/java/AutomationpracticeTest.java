import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationpracticeTest {

    WebDriver driver;
    public List<WebElement> getProducts() {
        return driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li"));
    }


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\selenium-java-3.141.59\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().deleteAllCookies();
    }


    @Test
    public void pageNavigationTest() {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        String currentUrl = driver.getCurrentUrl();

        assertEquals("http://automationpractice.com/index.php?id_category=5&controller=category",
                currentUrl);
    }


    @Test
    public void homePageTest() throws IOException {
        driver.findElement(By.cssSelector(".login")).click();

        assertEquals("Sign in", driver.findElement(By.cssSelector("#SubmitLogin")).getText());

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/homePage.png"));
        }
    }


    @Test
    public void bestSellersTabCountTest() throws IOException {
        driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a")).click();

        assertEquals(7, getProducts().size());

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/bestSellersCount.png"));
        }

    }


    @Test
    public void isInvalidEmailTextDisplayed() throws Exception {
        driver.manage().window().setSize(new Dimension(600, 600));
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("SubmitCreate")).click();
        WebElement allertField = driver.findElement(By.id("create_account_error"));
        WebElement invalidEmailText = allertField.findElement(By.xpath("//*[contains(text(), 'Invalid email address.')]"));

        assertTrue(allertField.isDisplayed());
        assertTrue(invalidEmailText.isDisplayed());

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/invalidEmailTextDisplayed.png"));
        }
    }


    @Test
    public void loginWithInvalidDataTest() throws IOException {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("fakemailtest@test.com");
        driver.findElement(By.xpath("//form[@id='login_form']/div")).click();
        driver.findElement(By.name("passwd")).sendKeys("test");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/invalidDataLogin.png"));
        }
    }


    @Test
    public void registrationWithIncompleteDataTest() throws InterruptedException, IOException {

        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();
        driver.findElement((By.id("email_create"))).sendKeys("fakemailtest@test.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Kamil");
        driver.findElement(By.id("customer_lastname")).sendKeys("Abc");
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(2000);

        boolean isAlertDisplayed = driver.findElement(By.className("alert")).isDisplayed();
        assertTrue(isAlertDisplayed);

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/incompleteDataRegistration.png"));
        }
    }


    @Test
    public void checkBoxTest() throws IOException {
        driver.manage().window().setSize(new Dimension(400, 800));
        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();
        driver.findElement((By.id("email_create"))).sendKeys("fakemailtest@test.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label")).click();

        assertTrue(driver.findElement(By.id("newsletter")).isEnabled());

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/checkBox.png"));
        }
    }


    @Test
    public void registrationWithValidDataTest() throws InterruptedException, IOException {
        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();
        driver.findElement((By.id("email_create"))).sendKeys("testmaila1234@test.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Kamil");
        driver.findElement(By.id("customer_lastname")).sendKeys("Abc");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        Select sDate = new Select(driver.findElement(By.id("days")));
        sDate.selectByValue("22");
        Select sMonth = new Select(driver.findElement(By.id("months")));
        sMonth.selectByValue("5");
        Select sYear = new Select(driver.findElement(By.id("years")));
        sYear.selectByValue("1984");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("PJWSTK");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Brzegi");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Miami");
        Select sState = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
        sState.selectByVisibleText("Florida");
        driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("12345");
        Select sCountry = new Select(driver.findElement(By.xpath("//*[@id='id_country']")));
        sCountry.selectByVisibleText("United States");
        driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("123457876");

        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(2000);

        assertTrue(driver.findElement(By.className("info-account")).isDisplayed());

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/validDataRegistration.png"));
        }
    }


    @Test
    public void loginWithValidDataTest() throws IOException {
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("testmaila1234@test.com");
        driver.findElement(By.xpath("//form[@id='login_form']/div")).click();
        driver.findElement(By.name("passwd")).sendKeys("12345");

        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", currentUrl);

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshots/validDataLogin.png"));
        }
    }


    @After
    public void cleanup() {
        driver.quit();
    }

}
