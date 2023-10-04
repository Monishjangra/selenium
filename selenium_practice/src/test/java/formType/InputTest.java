package formType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.MyListener;
import tests.Common;

@Listeners(MyListener.class)
public class InputTest extends Common {

//    public InputTest() {
//        super();
//    }

	@Test(priority = 1)
	public void inputName() throws InterruptedException {
		homePage.input(prop.getProperty("inputName"), prop.getProperty("inputEmail"), prop.getProperty("inputPhone"));
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void date() throws InterruptedException {
		String[] len = prop.getProperty("date").split(" ");
		String date = len[0];
		String month = len[1];
		String year = len[2];
		homePage.date(date, month, year);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void dragDrop() throws InterruptedException {
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).release().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@id ='droppable']//child::p")).getText());
	}

	@Test(priority = 4)
	public void slider() throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath("//div[@id = 'slider']//child::span"));
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, 80, 0).perform();
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void resizable() throws InterruptedException {
		WebElement resize = driver.findElement(By
				.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", resize);
		Actions move = new Actions(driver);
		System.out.println(driver.findElement(By.id("resizable")).getSize().width);
		System.out.println(driver.findElement(By.id("resizable")).getSize().height);
//		move.clickAndHold(resize).moveByOffset(200, 200).release().build().perform();
		move.dragAndDropBy(resize, 200, 200).build().perform();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.id("resizable")).getSize().width);
		System.out.println(driver.findElement(By.id("resizable")).getSize().height);
	}
}
