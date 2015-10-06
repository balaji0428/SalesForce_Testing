package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 10/5/2015.
 */
public class BaseTest {

    public WebDriver driver = null;

    public void salesForce(String username, String password) {
        driver = new FirefoxDriver();
        driver.get("http://www.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='button-login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='Login']")).click();

    }

    public void menuOptions() {
        salesForce("mum2be0920@gmail.com", "Katakam1987");
        driver.findElement(By.xpath(".//*[@id='sales-rep-choice']/p/label")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='tsidButton']")).click();
    }
}
