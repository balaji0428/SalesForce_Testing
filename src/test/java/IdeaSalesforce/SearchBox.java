package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by balajik1 on 08/10/2015.
 */
public class SearchBox extends BaseTest {
    @Test
    public void searchBox() {

        salesForce("mum2be0920@gmail.com", "Katakam1987");

        driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys("Sravani Katakam");
        driver.findElement(By.xpath(".//*[@id='phSearchButton']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String check = driver.findElement(By.xpath(".//*[@id='User_body']/table/tbody/tr[2]/th/div/div/a")).getText();
        Assert.assertEquals(check, "sravani Katakam");
        System.out.println(check);

        driver.close();
    }

    @Test
    public void count() {
        salesForce("mum2be0920@gmail.com", "Katakam1987");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='tsid-arrow']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement> elementsList = driver.findElements(By.xpath(".//*[@id='tsid-menuItems']/a"));

        System.out.println(elementsList.size());
        System.out.println(driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[1]")).getText());

//                   for (int i = 0; i <= elementsList.size(); i++) {
//
//                System.out.println(elementsList.get(i).getText());
//
//
//            }
    }
}






























































































































































































































