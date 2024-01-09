package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
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
    public void additionalInfo(){
        WebElement element= driver.findElement(By.id("grouptab_0"));
        Actions actions=new Actions(driver);

        actions.moveToElement(element);
        WebElement element1= driver.findElement(By.xpath("//*[@id=\"toolbar\"]/ul/li[2]/span/ul/li[5]"));
        actions.moveToElement(element1).click().build().perform();


    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
