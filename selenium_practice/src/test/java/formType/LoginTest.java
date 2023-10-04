package formType;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.MyListener;

@Listeners(MyListener.class)
public class LoginTest {

    public WebDriver driver;
	
    @BeforeClass
    public void onStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyValidLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).isDisplayed(), "not displayed");
        Thread.sleep(2000);
        
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password')]")).isDisplayed());
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void verifyWithoutPasswordLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Password is required')]")).isDisplayed());
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void verifyWithoutUsernameLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]")).isDisplayed());
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void verifyWithoutUsernameAndPasswordLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]")).isDisplayed());
        Thread.sleep(2000);
    }
}
