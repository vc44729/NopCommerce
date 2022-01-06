package nopCommerceStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement logBtn;
	@FindBy(xpath="//a[@class='ico-register']")
	WebElement registerBtn;
	public void clickLogin() {
		logBtn.click();
	}
	public void clickRegister() {
		registerBtn.click();
	}

}
