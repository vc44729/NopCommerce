package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import nopCommerceStore.SearchPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Search {
	public WebDriver driver;
	public SearchPage sc;
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
  @Test
  public void Search_test() {
	  test = report.createTest("Search_test");
	  sc.clickSearch();
	  sc.enterInput("laptop");
	  sc.clickBtn();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://frontend.nopcommerce.com/");
	  driver.switchTo().frame(0);
	  sc=new SearchPage(driver);
	 
  }

  @AfterMethod
  public void afterMethod() {
	// driver.close();
		 report.flush();
  }
  @BeforeClass
  public void beforeClass() {
  reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report2.html");
  reporter.config().setTheme(Theme.DARK);
  reporter.config().setDocumentTitle("SampleReport");
  reporter.config().setReportName("FunctionalTest Report");
  report = new ExtentReports();
  report.attachReporter(reporter);
  }
}
