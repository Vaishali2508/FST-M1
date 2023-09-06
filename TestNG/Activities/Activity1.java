
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Activity1 {
    WebDriver driver;
        @BeforeMethod
        public void beforeMethod(){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            driver.get("https://v1.training-support.net/");
        }
        @Test
        public void testActivity(){
            System.out.println("Title of Home page is :" +driver.getTitle());
            Assert.assertEquals("Training Support", driver.getTitle());
            driver.findElement(By.id("about-link")).click();
            System.out.println("Title of About page is :" + driver.getTitle());
            Assert.assertEquals("About Training Support", driver.getTitle());
        }
        @AfterMethod
    public void afterMethod(){
            driver.close();
        }

    }
