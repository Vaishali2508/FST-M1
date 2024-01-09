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

public class Activity6 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test(priority = 1)
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
    @Test(priority = 2)
    public void itemMenu(){
        WebElement item = driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
        Assert.assertEquals("Activities",item);
        System.out.println("Activities Menu exist");

    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
