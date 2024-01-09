package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void testActivity() {
        String Footer= driver.findElement(By.id("admin_options")).getText();
        System.out.println("Footer text is:" + Footer);

    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}

