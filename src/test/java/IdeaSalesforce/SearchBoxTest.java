package IdeaSalesforce;

import com.salesforce.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by balajik1 on 08/10/2015.
 */
public class SearchBoxTest extends PageBase {
    @Test
    public void searchBox() {

        loginPage().loginMethod("mum2be0920@gmail.com", "Katakam1987");

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
        loginPage().loginMethod("mum2be0920@gmail.com", "Katakam1987");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='tsid-arrow']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement> elementsList = driver.findElements(By.xpath(".//*[@id='tsid-menuItems']/a"));

        System.out.println(elementsList.size());
        System.out.println(driver.findElement(By.xpath(".//*[@id='tsid-menuItems']/a[1]")).getText());
    }

//                   for (int i = 0; i <= elementsList.size(); i++) {
//
//                System.out.println(elementsList.get(i).getText());
//
//
//            }
    @Test
    public void tabBar() {
        loginPage().loginMethod("mum2be0920@gmail.com", "Katakam1987");

        List<WebElement> tleCount = driver.findElements(By.xpath(".//*[@id='tabBar']/li"));
        System.out.println(tleCount.size());
        for (int i= 0 ;i<tleCount.size();i++) {
            System.out.println(tleCount.get(i).getText());

        }
    }
    @Test
    public void chat (){
        loginPage().loginMethod("mum2be0920@gmail.com", "Katakam1987");
        driver.findElement(By.xpath(".//*[@id='buddy_list_min_text']")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='presence_buddy_search']")).sendKeys("Sravani");
        driver.findElement(By.xpath(".//*[@id='roster_title_expanded']/div")).click();

    }

    }































































































































































































































