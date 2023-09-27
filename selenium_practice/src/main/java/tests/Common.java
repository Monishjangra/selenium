package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Common {

    public WebDriver driver;

    public Properties prop;

    public HomePage homePage;

    public Common() {
        prop = new Properties();
        File propFile = new File("src/test/java/resources/config.properties");
        try {
            FileInputStream file = new FileInputStream(propFile);
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void onStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }
}
