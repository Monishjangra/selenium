package formType;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ButtonTest extends CommonTest {

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

    @Test(priority = 3, dataProvider="dataSupplier")
    public void dropdown(String data) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"country\"]")).findElement(By.xpath(data)).click();
        Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] dataSupplier(){
        return new Object[][]{{"//*[@id=\"country\"]/option[5]"}, {"//*[@id=\"country\"]/option[8]"},{"//*[@id=\"country\"]/option[6]"}};
    }

}
