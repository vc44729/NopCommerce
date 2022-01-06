package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Title {
	public WebDriver driver;
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
  @Test
  public void Title_test() {
	  test = report.createTest("Title_test");
	  String title=driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "nopCommerce demo store");
	  test.log(Status.PASS, "Title page is present");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.get("https://frontend.nopcommerce.com/");
		  driver.switchTo().frame(0);
		
  }
  @AfterMethod
  public void afterMethod() {
	 driver.close();
	 report.flush();
  }
  @BeforeClass
  public void beforeClass() {
  reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report3.html");
  reporter.config().setTheme(Theme.DARK);
  reporter.config().setDocumentTitle("SampleReport");
  reporter.config().setReportName("FunctionalTest Report");
  report = new ExtentReports();
  report.attachReporter(reporter);
  }
}
