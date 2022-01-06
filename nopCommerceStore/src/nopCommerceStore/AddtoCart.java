package nopCommerceStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
	public WebDriver driver;
	public AddtoCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//div[@class='item-grid']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
WebElement clk;
@FindBy(xpath="//button[@id='add-to-cart-button-4']")
WebElement add;
public void clickAddtoCart() {
	clk.click();
}

public void clickAdd() {
	add.click();
}
}
