package IdeaSalesforce;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 9/30/2015.
 */
public class LoginTest extends BaseTest {
    //Junit --- Commenly used TestNg
//    protected WebDriver driver;
//    public LoginTest(WebDriver dr){
//        this.driver = dr;
//    }
    @Test
    public void enterValidCredentials() {
        salesForce("mum2be0920@gmail.com", "Katakam1987");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String username = driver.findElement(By.xpath(".//*[@id='userNavLabel']")).getText();
        System.out.println(username);
        Assert.assertEquals(username, "sravani Katakam", "Username match");

        driver.quit();
    }

 @Test
    public void enterInvalidCredentials()
  {
        salesForce("mum2be0920gmail.com", "katakam1987");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String errormsg = driver.findElement(By.xpath(".//*[@id='error']")).getText();
        System.out.println(errormsg);
        Assert.assertEquals(errormsg,"Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.", "Message displayed");
        driver.quit();
    }
    @Test
    public void salesRep()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='sales-rep-choice']")).click();
        driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
        driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='tsidButton']")).click();
        driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[1]")).click();
        String sales = driver.findElement(By.xpath(".//*[@id='chatterTab']/div[1]/h1")).getText();
        System.out.println(sales);
        Assert.assertEquals(sales, "BugFinder", "BugFinder");

        driver.quit();
    }

          @Test
                  public void sales()
          {
              salesForce("mum2be0920@gmail.com", "Katakam1987"); //Login Method
              String dropdown = driver.findElement(By.xpath(".//*[@id='tsidButton']")).getText();
              Assert.assertEquals(dropdown, "Sales", "Sales");
              System.out.println(dropdown);
              driver.quit();
          }

    @Test
    public void verifyUserIsLoggedIn()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> webObject = driver.findElements(By.xpath(".//*[@id='userNavLabel']"));

        if(webObject.size() != 0)
        {
            Assert.assertTrue(false, "User not logged in");
        }

        else
        {
            Assert.assertTrue(true, "User logged in");
        }
    }

    @Test
    public void sfChatter() {
        salesForce("mum2be0920@gmail.com", "Katakam1987");

        String sfChatter = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[1]")).getText();
        Assert.assertEquals("Salesforce Chatter", "Salesforce Chatter");
        System.out.println(sfChatter);
        driver.quit();
    }
        @Test
        public void marketing()
        {
            salesForce("mum2be0920@gmail.com", "Katakam1987");

          String marketing = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[2]")).getText();
          Assert.assertEquals("Marketing", "Marketing");
          System.out.println(marketing);
            driver.quit();
        }
    @Test
    public void callCenter()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");


          String callCenter = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[3]")).getText();
          Assert.assertEquals("CallCenter", "CallCenter");
          System.out.println(callCenter);
        driver.quit();
    }
    @Test
    public void checkout()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");

          String checkout = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[4]")).getText();
          Assert.assertEquals("Checkout", "Checkout");
          System.out.println(checkout);
        driver.quit();

    }
    @Test
    public void appExchange()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");

          String appExchange = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[5]")).getText();
          Assert.assertEquals("AppExchange", "AppExchange");
          System.out.println(appExchange);
        driver.quit();
    }
    @Test
    public void devCommunity()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");


          String devCommunity = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[6]")).getText();
          Assert.assertEquals("Developer Community", "Developer Community");
          System.out.println(devCommunity);
        driver.quit();

    }
    @Test
    public void successCommunity()
    {
        salesForce("mum2be0920@gmail.com", "Katakam1987");

          String successCommunity = driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[7]")).getText();
          Assert.assertEquals("Success Community", "Success Community");
          System.out.println(successCommunity);

          driver.quit();
      }

//    @Test
//    public void searchBox () {
//        salesForce("mom2be0920@gmail.com", "Katakam1987");
//        menuOptions();
//
//        driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys("Sravani Katakam");
//        driver.findElement(By.id("phSearchInput")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//        //String check =  driver.findElement(By.className("displayName")).getText();
//        //Assert.assertEquals("sravani Katakam","sravani Katakam");
//        // System.out.println(check);
//        driver.close();
    }










