package formType;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasicTest {
	
	
	public void main() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
//		Open a page
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.google.com/");
		driver.close();
		
//		Current URL
		System.out.println(driver.getCurrentUrl());
		
//		Title of web site
		System.out.println(driver.getTitle());
		
//		back | forward | refresh
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
//		switch to window
		String orginal = driver.getWindowHandle();
		driver.switchTo().window(orginal);
		
//		open a new window or new tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		
//		to close the tab
		driver.close();
		
//		to close the driver
		driver.quit();
		
//		frame
		driver.switchTo().frame("name"); // replace name with frame name or frame index
		driver.switchTo().defaultContent(); // back to main frame
		
//		get and set the size
		driver.manage().window().getSize().getHeight();
		driver.manage().window().getSize().getWidth();
		driver.manage().window().setSize(new Dimension(500, 400));
		
//		get and set the position
		driver.manage().window().getPosition();
		driver.manage().window().setPosition(new Point(20, 20));
		
//		screen size
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		
//		full screen screenshot
		File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("./image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Particular element screenshot
		WebElement element1 = driver.findElement(By.id("idName"));
		File file2 = element1.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file2, new File("./image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		java script
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button = driver.findElement(null);
		js.executeScript("arguments[0].click();", button);
		
//		page loading strategy
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
//		To press enter key
		driver.findElement(By.id(null)).sendKeys("hii", Keys.ENTER);
		
//		key down (press ctrl+a)
		Actions actions1 = new Actions(driver);
		Action keydown = actions1.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		
//		key up (shift)
		Actions actions2 = new Actions(driver);
		WebElement search = driver.findElement(By.id(null));
		actions2.keyDown(Keys.SHIFT).sendKeys(search, "selenium").keyUp(Keys.SHIFT).sendKeys(" hello").perform();
		
//		to clear the input box
		search.clear();
		
//		mouse actions
		Actions actions3 = new Actions(driver);
		WebElement element2 = driver.findElement(By.id(null));
		WebElement element3 = driver.findElement(By.id(null));
		
		actions3.moveToElement(element2); // hover
		actions3.clickAndHold();
		actions3.moveToElement(element3);
		actions3.contextClick(element3).perform(); // right click
		actions3.doubleClick(element3).perform();
		
//		drag and drop
		actions3.dragAndDrop(element2, element3);
		
//		drop down
		WebElement dropdown = driver.findElement(By.id(null));
		Select select = new Select(dropdown);
		select.selectByIndex(0);
		select.selectByValue("");
		select.selectByVisibleText("");
		
		List<WebElement> allOptionsElements = select.getOptions();		
		for(WebElement optionElement :allOptionsElements) {
			System.out.println(optionElement);
		}
		
		List<WebElement> allOptionsElements2 = driver.findElements(null);
		for(WebElement option2: allOptionsElements2) {
			if(option2.getText().equalsIgnoreCase("option 2")) {
				option2.click();
			}
		}
 		

	}

}
