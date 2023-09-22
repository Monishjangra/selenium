package formType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonTest {

    public WebDriver driver;

    public Properties prop;

    public CommonTest() {
        prop = new Properties();
        File propFile = new File("src/test/java/resources/config.properties");
        try {
            FileInputStream file = new FileInputStream(propFile);
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void onStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void terminate() {
        driver.quit();
    }
}
