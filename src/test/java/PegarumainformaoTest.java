import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class PegarumainformaoTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    private static AtomicLong screenshotCounter = new AtomicLong();

    @Before
    public void setUp() {
        try {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
            js = (JavascriptExecutor) driver;
            vars = new HashMap<String, Object>();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void pegarumainformao() {
        // Test name: Pegar uma informação
        // Step # | name | target | value | comment
        // 1 | open | / |  |
        driver.get("https://www.mercadolivre.com.br/");
        // 2 | setWindowSize | 1936x1048 |  |
        takeScreenshot(driver);

        driver.manage().window().setSize(new Dimension(1936, 1048));

        takeScreenshot(driver);

        // 3 | click | id=cb1-edit |  |
        driver.findElement(By.id("cb1-edit")).click();

        takeScreenshot(driver);


        // 4 | type | id=cb1-edit | agua desmineralizada |
        driver.findElement(By.id("cb1-edit")).sendKeys("agua desmineralizada");
        // 5 | mouseDown | id=cb1-opt1-1 |  |
        {
            WebElement element = driver.findElement(By.id("cb1-opt1-1"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        takeScreenshot(driver);
        // 6 | mouseUp | linkText=Ofertas do dia |  |
        {
            WebElement element = driver.findElement(By.linkText("Ofertas do dia"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        // 7 | click | css=.nav-bounds-with-cart |  |
        driver.findElement(By.cssSelector(".nav-bounds-with-cart")).click();
        // 8 | mouseOver | linkText=Água Desmineralizada Deionizada Autoclave 2 Galões De 5litro |  |
        {
            WebElement element = driver.findElement(By.linkText("Água Desmineralizada Deionizada Autoclave 2 Galões De 5litro"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        // 9 | click | linkText=Água Desmineralizada Deionizada Autoclave 2 Galões De 5litro |  |
        driver.findElement(By.linkText("Água Desmineralizada Deionizada Autoclave 2 Galões De 5litro")).click();
        // 10 | mouseOver | css=.andes-button--filled |  |
        {
            WebElement element = driver.findElement(By.cssSelector(".andes-button--filled"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        // 11 | click | css=.onboarding-cp-button:nth-child(2) > .andes-button__content |  |
        driver.findElement(By.cssSelector(".onboarding-cp-button:nth-child(2) > .andes-button__content")).click();
        // 12 | click | css=.pl-16 |  |
        driver.findElement(By.cssSelector(".pl-16")).click();
    }

    public static void takeScreenshot(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot" + screenshotCounter.incrementAndGet() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
