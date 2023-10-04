package formType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.MyListener;
import tests.Common;


@Listeners(MyListener.class)
public class ButtonTest extends Common {

	@Test(priority = 1)
	public void radio() throws InterruptedException {
		homePage.male();
		homePage.feMale();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void checkBox() throws InterruptedException {
		homePage.sunday();
		homePage.monday();
		Thread.sleep(2000);
	}

	@Test(priority = 3, dataProvider = "dataSupplier")
	public void dropdown(String data) throws InterruptedException {
		homePage.dropDown(data);
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] dataSupplier() {
		return new Object[][] { { "//*[@id='country']/option[@value = 'india']" },
				{ "//*[@id='country']/option[@value = 'france']" }, { "//*[@id='country']/option[@value = 'china']" } };
	}

	@Test(priority = 4)
	public void select() throws InterruptedException {
		homePage.select();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void newWindow() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onClick = 'myFunction()']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void doubleClick() throws InterruptedException {
		WebElement field = driver.findElement(By.id("field1"));
		field.clear();
		field.sendKeys("Monish");
		WebElement dblclick = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions actions = new Actions(driver);
		actions.doubleClick(dblclick).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("field2")).getAttribute("value"), "Monish");
	}

}
