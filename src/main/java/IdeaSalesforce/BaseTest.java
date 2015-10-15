package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 10/5/2015.
 */

public class BaseTest {
    public WebDriver driver = null;
    protected WebDriver localDriver = null;
    private String chromePath = "C:\\Users\\BalajiK1\\Desktop\\VeriFone\\Idea_SF\\Drivers\\chromedriver_win32";
    private String iExplorerPath = "C:\\Users\\BalajiK1\\Desktop\\VeriFone\\Idea_SF\\Drivers\\IEDriverServer_x64_2.48.0";
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
   // driver.close();
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
           System.setProperty("webdriver.ie.driver" , iExplorerPath);
            localDriver = new InternetExplorerDriver();
        }
        localDriver.manage().window().maximize();
        return driver = localDriver;

    }

    public void checkLoginStatus()
    {
        List<WebElement> login = driver.findElements(By.xpath(".//*[@id='userNavLabel']"));
        if (login.equals(".//*[@id='userNavLabel']")) {
            driver.findElement(By.xpath(".//*[@id='userNav-arrow']")).click();
            driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]")).click();
        }
        else {
            invoke();
        }
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

