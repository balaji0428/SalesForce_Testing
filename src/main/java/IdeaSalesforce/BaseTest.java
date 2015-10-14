package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 10/5/2015.
 */

public class BaseTest {
    public WebDriver driver = null;
    protected WebDriver localDriver = null;
    private String chromePath = "";
    private String baseUrl = "http://www.salesforce.com/";

    @BeforeTest
    public void invoke ()
    {
        getBrowser("firefox");
        driver.get(baseUrl);

    }
@AfterTest
public void tearDown()
{
    driver.close();
    driver.quit();
}
    public WebDriver getBrowser(String browserType)
    {
        if(browserType.equals("firefox"))
        {
            localDriver = new  FirefoxDriver();
        }
        else if(browserType.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", chromePath);
            localDriver = new ChromeDriver();
        }
        else if(browserType.equals("ie"))
        {

        }
        localDriver.manage().window().maximize();
        return driver = localDriver;

    }
    public void checkLoginStatus()
    {

    }

    public void salesForce(String username, String password) {

        driver.findElement(By.xpath(".//*[@id='button-login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='Login']")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='sales-rep-choice']/p/label")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='tsidButton']")).click();

    }

//    public void menuOptions() {
//        salesForce("mum2be0920@gmail.com", "Katakam1987");
//        driver.findElement(By.xpath(".//*[@id='sales-rep-choice']/p/label")).click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElement(By.xpath(".//*[@id='tsidButton']")).click();
    }

