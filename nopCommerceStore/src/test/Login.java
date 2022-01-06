package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import nopCommerceStore.HomePage;
import nopCommerceStore.LoginPage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.ExcelUtils;
import utilities.ExcelUtils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Login {
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
  @Test
  public void LoginPageTest() throws Exception {
	 for(int i=1;i<ExcelUtils.getRowCount();i++) 
	 {
		 test = report.createTest("LoginTest__"+i);
	 hp.clickLogin();
	 lp.enterUserName(ExcelUtils.getCellData(i, 0));
	 lp.enterPws(ExcelUtils.getCellData(i, 1));
	 lp.clickLogin();
	String text= driver.findElement(By.xpath("//a[@class='ico-register']")).getText();
	 if(text.contains("My account"))
			 {
		 ExcelUtils.setCellData("Pass", i, 2);
		 test.log(Status.PASS, "Test Case Passed for Valid data");
		 
	 }else {
		 ExcelUtils.setCellData("Fail", i, 2);
		 test.log(Status.PASS, "Test Case Pass for InValid data");
	 }
	}
  } 
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	  ExcelUtils.setExcelFile(Constant.filename,"Login");
	  driver= new ChromeDriver();
	  driver.get("https://frontend.nopcommerce.com/");
	  driver.switchTo().frame(0);
	  hp=new HomePage(driver);
	  lp=new LoginPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.close();
	  report.flush();
  }
  @BeforeClass
  public void beforeClass() {
  reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report.html");
  reporter.config().setTheme(Theme.DARK);
  reporter.config().setDocumentTitle("SampleReport");
  reporter.config().setReportName("FunctionalTest Report");
  report = new ExtentReports();
  report.attachReporter(reporter);
  }
}
