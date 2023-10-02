 package formType;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import tests.Common;

public class TableTest extends Common {
	
	@Test(priority = 1)
	public void table() {
		List<WebElement> dataset = driver.findElements(By.xpath("//table[@name = 'BookTable']//descendant::td[text() = '" +prop.getProperty("bookName") + "' ]//following-sibling::td"));
		for(WebElement data: dataset) {
			System.out.println(data.getText());
		}
	}
	
	@Test(priority = 2)
	public void paginationTable() {
		driver.findElement(By.xpath("//div[@class = 'table-container']//descendant::td[text() ='" +prop.getProperty("productName") + "']//following-sibling::td//child::input")).click();
	}

}
