package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='male']")
    private WebElement maleRadio;

    @FindBy(xpath = "//*[@id='female']")
    private WebElement femaleRadio;

    @FindBy(xpath = "//*[@id=\"sunday\"]")
    private WebElement sundayCheckBox;

    @FindBy(xpath = "//*[@id=\"monday\"]")
    private WebElement mondayCheckBox;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement dropdown;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;
    
    @FindBy(id = "colors")
    private WebElement select;
    
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
    select();
    }
    
    public void select() {
    	select.findElement(By.xpath("//option[text()='Red']")).click();    	
    }

	public void date(String date) {
		dateData.sendKeys(date);
		
	}

}