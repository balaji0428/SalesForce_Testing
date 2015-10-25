package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.ObjectRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 10/5/2015.
 */

public class BaseTest {
    public WebDriver driver = null;
    protected WebDriver localDriver = null;
    private EnvironmentConfiguration loadEnv;
    @BeforeTest
    public void invoke ()
    {
        loadEnv =  new EnvironmentConfiguration("test");
        getBrowser(loadEnv.getBrowser());
        driver.get(loadEnv.getBaseUrl());

    }
@AfterTest
public void tearDown()
{
   // driver.close();
    driver.quit();
}
    public WebDriver getBrowser(String browserType) {
        if (browserType.equals("firefox")) {
            localDriver = new FirefoxDriver();
        } else if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ObjectRepository.chromePath);
            localDriver = new ChromeDriver();
        } else if (browserType.equals("ie")) {
            System.setProperty("webdriver.ie.driver", ObjectRepository.iExplorerPath);
            localDriver = new InternetExplorerDriver();
        }
        localDriver.manage().window().maximize();
        return driver = localDriver;
    }
        public boolean waitForElementAvailable(WebDriver driver,By locator,long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
            return false;

    }
    

//    public void menuOptions() {
//        loginMethod("mum2be0920@gmail.com", "Katakam1987");
//        driver.findElement(By.xpath(".//*[@id='sales-rep-choice']/p/label")).click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElement(By.xpath(".//*[@id='tsidButton']")).click();
    }

