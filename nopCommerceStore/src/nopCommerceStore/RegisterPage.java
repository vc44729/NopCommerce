package nopCommerceStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="gender-male")
	WebElement gen;
	@FindBy(id="FirstName")
	WebElement firstName;
	@FindBy(id="LastName")
	WebElement lastName;
	@FindBy(id="Email")
	WebElement email;
	@FindBy(id="Password")
	WebElement pws;
	@FindBy(id="ConfirmPassword")
	WebElement confPws;
	@FindBy(id="register-button")
	WebElement regBtn;
	public void clickgen() {
		gen.click();
	}
	public void enterFirstName(String fstName) {
		firstName.clear();
		firstName.sendKeys(fstName);
	}
	public void enterLastName(String lstName) {
		lastName.clear();
		lastName.sendKeys(lstName);
	}
	public void enterEmail(String eml) {
		email.clear();
		email.sendKeys(eml);
	}
	public void enterPWS(String pass) {
		pws.clear();
		pws.sendKeys(pass);
	}
	public void confPWS(String conPass) {
		confPws.clear();
		confPws.sendKeys(conPass);
		
	}
	public void clickRegister() {
		regBtn.click();
	}
}
