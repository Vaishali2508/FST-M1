package activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity1 {
    //Driver Declaration
    WebDriver driver;

    @BeforeClass
    public  void setUp() throws MalformedURLException {
        //Set Desired Capabilities
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        //Set Appium Server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize AndroidDriver
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void calculatorTest(){
        //Find digit 5
        WebElement digit5= driver.findElement(By.id("digit_5"));
        digit5.click();
        //Find Multiplication symbol
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //Find digit 5
        digit5.click();
        //Find equals and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //Assertion
        String result= driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result, "25");

    }
    @AfterClass
    public void tearDown(){
        //close the app
        driver.quit();
    }
}
