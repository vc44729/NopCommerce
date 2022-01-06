package nopCommerceStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(id="Email")
   WebElement email;
   @FindBy(id="Password")
   WebElement pass;
   @FindBy(xpath="//button[text()='Log in']")
   WebElement btn;
   public void enterUserName(String username) {
	   email.clear();
	   email.sendKeys(username); 
   }
   public void enterPws(String pws) {
	   pass.clear();
	   pass.sendKeys(pws);
   }
   public void clickLogin() {
	   btn.click();
   }
}
