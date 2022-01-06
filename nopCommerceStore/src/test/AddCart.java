package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import nopCommerceStore.AddtoCart;
import nopCommerceStore.HomePage;
import nopCommerceStore.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AddCart {
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	public AddtoCart ad;
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
  @Test
  public void Add_test() {
	  test = report.createTest("AddtoCart_test");
	  hp.clickLogin();
	  lp.enterUserName("vc44729@gmail.com");
	  lp.enterPws("Test@123");
	  lp.clickLogin();
	  ad.clickAddtoCart();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  ad.clickAdd();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.get("https://frontend.nopcommerce.com/");
		  driver.switchTo().frame(0);
		  hp=new HomePage(driver);
		  lp=new LoginPage(driver);
		  ad =new AddtoCart(driver);
		 
  }

  @AfterMethod
  public void afterMethod() {
	// driver.close();
			 report.flush();
  }
  @BeforeClass
  public void beforeClass() {
  reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report4.html");
  reporter.config().setTheme(Theme.DARK);
  reporter.config().setDocumentTitle("SampleReport");
  reporter.config().setReportName("FunctionalTest Report");
  report = new ExtentReports();
  report.attachReporter(reporter);
  }
}
