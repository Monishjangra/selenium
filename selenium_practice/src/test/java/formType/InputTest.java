package formType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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
		homePage.date(prop.getProperty("date"));
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

//	@Test(priority = 4)
//	public void resizable() throws InterruptedException {
//		WebElement resize = driver.findElement(By.id("resizable"));
//		int size = resize.getSize().width;
//		System.out.println(size);
//		Actions action = new Actions(driver);
//		action.clickAndHold(resize).moveByOffset(130,130).release().perform();
//		Thread.sleep(5000);
//		System.out.println(resize.getSize().width);
//	}
}
