import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class Activity5 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void pageTitle() {
    String title=driver.getTitle();
    Assert.assertEquals(title, "Target Practice");
    }
    @Test(groups = {"HeaderTests"})
    public void headerTest() {
        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));
        System.out.println("Print 3rd header" + header3);
        Assert.assertEquals(header3.getText(),"Third header");
        WebElement header5=driver.findElement(By.xpath("//h5[@class=\"ui green header\"]"));
        Assert.assertEquals(header5.getCssValue("color"),"rgb(33, 186, 69)");
    }

    @Test(groups = {"ButtonTests"})
    public  void  buttonTest(){
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }


    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}

