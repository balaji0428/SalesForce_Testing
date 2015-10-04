package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 9/30/2015.
 */
public class LoginTest {
    //Junit --- Commenly used TestNg
   // WebDriver driver = null;
    @Test

    public void enterValidCredentials() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='button-login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("mum2be0920@gmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Katakam1987");
        driver.findElement(By.xpath(".//*[@id='Login']")).click();
       String username = driver.findElement(By.xpath(".//*[@id='userNavLabel']")).getText();
        System.out.println(username);
        Assert.assertEquals(username, "sravani Katakam", "Username match");
        driver.quit();

    }
 @Test
    public void enterInvalidCredentials()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='button-login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("mum2be20@gmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Katakam1987");
        driver.findElement(By.xpath(".//*[@id='Login']")).click();
        String errormsg = driver.findElement(By.xpath(".//*[@id='error']")).getText();
        System.out.println(errormsg);
        Assert.assertEquals(errormsg,"Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.", "Message displayed");
        driver.quit();
    }
    @Test
    public void salesRep()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='button-login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("mum2be0920@gmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Katakam1987");
        driver.findElement(By.xpath(".//*[@id='Login']")).click();
        driver.findElement(By.xpath(".//*[@id='sales-rep-choice']")).click();
        driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
        driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='tsidButton']")).click();
        driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[1]")).click();
        String sales = driver.findElement(By.xpath(".//*[@id='chatterTab']/div[1]/h1")).getText();
        System.out.println(sales);
        Assert.assertEquals(sales,"BugFinder","BugFinder");
        driver.quit();

    }
}



