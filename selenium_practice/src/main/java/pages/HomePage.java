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
    
    @FindBy(xpath = "//p[text() = 'Date: ']/input[@id= 'datepicker']")
    private WebElement dateData;

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

    public void sunday(){
        sundayCheckBox.click();
    }

    public  void monday(){
        mondayCheckBox.click();
    }

    public void dropDown(String data){
        dropdown.findElement(By.xpath(data)).click();
    }

    public void input(String inputName, String inputEmail, String inputPhone){
        name.sendKeys(inputName);
        email.sendKeys(inputEmail);
        phone.sendKeys(inputPhone);
    }
    
    public void select() {
    List<WebElement> options = driver.findElements(By.xpath("//label[@for='colors']//following::select//child::option"));
    for(WebElement option : options) {
    	if(option.getText().equalsIgnoreCase("red")) {
    		option.click();
    	}
    }
    }

	public void date(String date) {
		dateData.sendKeys(date);
		
	}

}