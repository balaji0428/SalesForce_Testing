package IdeaSalesforce;


import com.salesforce.pages.LoginPage;
import com.salesforce.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.ObjectRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Balaji on 9/30/2015.
 */
public class LoginTest extends PageBase {


    @BeforeMethod
    public void checkUserLogin()
    {

        if(loginPage().getTheUserNameCount() != 0)
        {
            loginPage().logOutTheUser();
            driver.get(ObjectRepository.baseUrl);
        }

        else if (loginPage().getTheErrorMessageCount()!=0)
    {
        driver.get(ObjectRepository.baseUrl);

    }
    }


    @Test
    public void enterValidCredentials() {


        loginPage().loginMethod(ObjectRepository.userName, ObjectRepository.passWord);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Assert.assertEquals(loginPage().getUserName(), "sravani Katakam", "Username match");

    }

 @Test
    public void enterInvalidCredentials()
  {

      loginPage().loginMethod(ObjectRepository.userId, ObjectRepository.passCode);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String errormsg = driver.findElement(By.xpath(ObjectRepository.ERRORMSG)).getText();
        System.out.println(errormsg);
        Assert.assertEquals(errormsg,"Please check your username and password. If you still can't log in, contact your Salesforce administrator.", "Message displayed");

    }

    }










