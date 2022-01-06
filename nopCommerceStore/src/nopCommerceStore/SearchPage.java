package nopCommerceStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="small-searchterms")
	WebElement search;
	@FindBy(xpath="//button[@type='submit']")
	WebElement scbtn;
	public void clickSearch() {
		search.click();
	}
	public void enterInput(String input) {
		search.sendKeys(input);
	}
	public void clickBtn() {
		scbtn.click();
	}
	
}
