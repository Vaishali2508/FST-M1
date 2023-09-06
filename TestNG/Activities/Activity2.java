import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;
        @BeforeClass
        public void beforeClass(){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            driver.get("https://v1.training-support.net/selenium/target-practice");
        }
        @Test
        public void firstMethod() {
            System.out.println("Title of Home page is :" + driver.getTitle());
            Assert.assertEquals("Target Practice", driver.getTitle());
        }
    @Test
    public void secondMethod() {
       WebElement blackButton=driver.findElement(By.className("ui black button"));
       Assert.assertTrue(blackButton.isDisplayed());
       Assert.assertEquals(blackButton.getText(),"black");
    }
    @Test(enabled = false)
    public void thirdMethod(){
        System.out.println("This method is skipped");
    }
    @Test
    public void fourthMethod() {
        throw new SkipException("Skipping test case");
    }
    @AfterClass
    public void afterClass(){
            driver.close();
        }

    }
