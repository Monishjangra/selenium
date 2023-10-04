package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//label[@for='male']//preceding::input[@id='male']")
	private WebElement maleRadio;

	@FindBy(xpath = "//label[@for='female']//preceding::input[@id='female']")
	private WebElement femaleRadio;

	@FindBy(xpath = "//label[@for='sunday']//preceding::input[@id='sunday']")
	private WebElement sundayCheckBox;

	@FindBy(xpath = "//label[@for='monday']//preceding::input[@id='monday']")
	private WebElement mondayCheckBox;

	@FindBy(xpath = "//label[@for='country']//following-sibling::select[@id='country']")
	private WebElement dropdown;

	@FindBy(xpath = "//label[text()= 'Name:']//following::input[@id = 'name']")
	private WebElement name;

	@FindBy(xpath = "//label[text()= 'Email:']//following::input[@id = 'email']")
	private WebElement email;

	@FindBy(xpath = "//label[text()= 'Phone:']//following::input[@id = 'phone']")
	private WebElement phone;

//    @FindBy(xpath = "//input[@id= 'datepicker']")
//    private WebElement dateData;

	@FindBy(xpath = "//label[@for='colors']//following::select//child::option")
	List<WebElement> options;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void male() {
		maleRadio.click();
	}

	public void feMale() {
		femaleRadio.click();
	}

	public void sunday() {
		sundayCheckBox.click();
	}

	public void monday() {
		mondayCheckBox.click();
	}

	public void dropDown(String data) {
		dropdown.findElement(By.xpath(data)).click();
	}

	public void input(String inputName, String inputEmail, String inputPhone) {
		name.sendKeys(inputName);
		email.sendKeys(inputEmail);
		phone.sendKeys(inputPhone);
	}

	public void select() {
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("red")) {
				option.click();
			}
		}
	}

	public void date(String inputDate, String inputMonth, String inputYear) throws InterruptedException {
		driver.findElement(By.xpath("//p[contains(text(),'Date')]//child::input")).click();
		WebElement month = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
		WebElement year = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']"));
		System.out.println(inputDate + inputMonth + inputYear);
		String[] totalMonth = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int inputIndex = 0;
		int currentIndex = 0;
		System.out.println(totalMonth.length);
		for (int i = 0; i < totalMonth.length; i++) {
			if (totalMonth[i].equalsIgnoreCase(inputMonth)) {
				inputIndex = i;
			}
			if (totalMonth[i].equalsIgnoreCase(month.getText())) {
				currentIndex = i;
			}
		}
		System.out.println(inputIndex + " " + currentIndex);

		if (Integer.parseInt(inputYear) < Integer.parseInt(year.getText())) {
			while (!(month.getText().equalsIgnoreCase(inputMonth) && year.getText().equalsIgnoreCase(inputYear))) {
				driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::a[@title='Prev']")).click();
				month = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
				year = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']"));
			}
		} else if (Integer.parseInt(inputYear) > Integer.parseInt(year.getText())) {
			while (!(month.getText().equalsIgnoreCase(inputMonth) && year.getText().equalsIgnoreCase(inputYear))) {
				driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::a[@title='Next']")).click();
				month = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
				year = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']"));
			}
		} else {
			if (inputIndex < currentIndex) {
				while (!(month.getText().equalsIgnoreCase(inputMonth) && year.getText().equalsIgnoreCase(inputYear))) {
					driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::a[@title='Prev']"))
							.click();
					month = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
					year = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']"));
				}
			} else if (inputIndex > currentIndex) {
				while (!(month.getText().equalsIgnoreCase(inputMonth) && year.getText().equalsIgnoreCase(inputYear))) {
					driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::a[@title='Next']"))
							.click();
					month = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
					year = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']"));
				}
			}
		}
		List<WebElement> date = driver.findElements(By.xpath("//tr/td/a"));
		for (WebElement dateElement : date) {
			if (dateElement.getText().equalsIgnoreCase(inputDate)) {
				dateElement.click();
				break;
			}
		}
		System.out.println(
				driver.findElement(By.xpath("//p[contains(text(),'Date')]//child::input")).getAttribute("value"));
	}

}