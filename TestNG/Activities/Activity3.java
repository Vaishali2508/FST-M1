import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod(){
       WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    public void loginTest() {
        WebElement username=driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));

        //Enter Credential
        username.sendKeys("admin");
        password.sendKeys("password");

        //Click login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Read the confirmation message
        String message= driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(message, "Welcome Back, admin");

    }
    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}
