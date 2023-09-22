package formType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTest {

    public WebDriver driver;

    @BeforeMethod
    public void onStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @AfterMethod
    public void terminate() {
        driver.quit();
    }
}
