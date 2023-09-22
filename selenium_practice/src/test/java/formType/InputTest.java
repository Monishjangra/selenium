package formType;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class InputTest extends CommonTest {

    public InputTest() {
        super();
    }

    @Test(priority = 1)
    public void inputName() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys(prop.getProperty("inputName"));
    }

    @Test(priority = 2)
    public void inputEmail() {
        driver.findElement(By.id("email")).sendKeys(prop.getProperty("inputEmail"));
    }

    @Test(priority = 3)
    public void inputPhone() {
        driver.findElement(By.id("phone")).sendKeys(prop.getProperty("inputPhone"));
    }
}
