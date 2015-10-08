package IdeaSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by balajik1 on 08/10/2015.
 */
public class SearchBox extends BaseTest {
    @Test
    public void searchBox (){

        salesForce("mum2be0920@gmail.com", "Katakam1987");

        driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys("Sravani Katakam");
        driver.findElement(By.xpath(".//*[@id='phSearchButton']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String check =  driver.findElement(By.xpath(".//*[@id='User_body']/table/tbody/tr[2]/th/div/div/a")).getText();
        Assert.assertEquals("sravani Katakam","sravani Katakam");
        System.out.println(check);

 driver.close();
    }
    @Test
    public void count() {
        salesForce("mum2be0920@gmail.com", "Katakam1987");
        Dimension xpathCount = driver.findElement(By.xpath(".//*[@id='phSearchButton']")).getSize();
        System.out.println(xpathCount);


       List menu  elementsList = driver.findElement(By.xpath(".//*[@id='tsidButton']"))
                System.out.println(elementsList.size());
// for( menu checkBox:elementsList) {
//                    int i = 0;
//                    checkBox = elementsList.get(i);


                }




//        salesForce("mum2be0920@gmail.com", "Katakam1987");
    }
}
