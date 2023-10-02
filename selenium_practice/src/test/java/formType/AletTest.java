package formType;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.MyListener;
import tests.Common;

@Listeners(MyListener.class)
public class AletTest extends Common {

	@Test(priority = 1)
	public void alert1() {
		driver.findElement(By.xpath("//button[@onClick='myFunctionAlert()']")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
	}

	@Test(priority = 2)
	public void alert2() {
		driver.findElement(By.xpath("//button[@onClick='myFunctionConfirm()']")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
	}

	@Test(priority = 3)
	public void alert3() {
		driver.findElement(By.xpath("//button[@onClick='myFunctionPrompt()']")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("Monish");
		alert1.accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
	}

}
