package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void loginTest() {
        WebElement username=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        //Enter Credential
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        //Click login button
        driver.findElement(By.id("bigbutton")).click();

        // Read the confirmation message
        WebElement element= driver.findElement(By.xpath("//*[@class='desktop-bar']/ul/li[1]/a"));
        Assert.assertEquals(element, "CREATE");

    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}

