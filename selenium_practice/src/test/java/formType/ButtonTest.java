package formType;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ButtonTest extends CommonTest{

    @Test(priority = 1)
    public void radio() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='male']")).click();
        driver.findElement(By.xpath("//*[@id='female']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void checkBox() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"sunday\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"monday\"]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void dropdown() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"country\"]")).findElement(By.xpath("//*[@id=\"country\"]/option[5]"));
        driver.findElement(By.xpath("//*[@id=\"country\"]")).findElement(By.xpath("//*[@id=\"country\"]/option[8]"));
        Thread.sleep(2000);
    }

}
