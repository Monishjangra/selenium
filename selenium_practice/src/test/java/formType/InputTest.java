package formType;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class InputTest extends CommonTest {

    @Test(priority = 1)
    public void inputName() {
        driver.findElement(By.id("name")).sendKeys("Monish");
    }

    @Test(priority = 2)
    public void inputEmail() {
        driver.findElement(By.id("email")).sendKeys("Monish");
    }

    @Test(priority = 3)
    public void inputPhone() {
        driver.findElement(By.id("phone")).sendKeys("12345");
    }
}
