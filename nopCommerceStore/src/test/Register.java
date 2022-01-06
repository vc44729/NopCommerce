package test;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import nopCommerceStore.HomePage;
import nopCommerceStore.RegisterPage;
import utilities.Constant;
import utilities.ExcelUtils;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Register {
	public WebDriver driver;
	public HomePage hp;
	public RegisterPage rp;
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
  @Test
  public void Reg_test() throws Exception {
	  for(int i=1;i<ExcelUtils.getRowCount();i++) {
	  test = report.createTest("Reg_test_" +i);
	 hp.clickRegister();
	 rp.clickgen();
	 rp.enterFirstName(ExcelUtils.getCellData(i, 0));
	 rp.enterLastName(ExcelUtils.getCellData(i, 1));
	 rp.enterEmail(ExcelUtils.getCellData(i, 2));
	 rp.enterPWS(ExcelUtils.getCellData(i, 3));
	 rp.confPWS(ExcelUtils.getCellData(i, 4));
	 rp.clickRegister();
	String abc= driver.findElement(By.xpath("//div[@class='result']")).getText();
	if(abc.contains("Your registration completed")) {
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		ExcelUtils.setCellData("Pass", i, 5);
		test.log(Status.PASS, "Test Case Passed for Valid data");
	}else {
		ExcelUtils.setCellData("Fail", i, 5);
		test.log(Status.PASS, "Test Case Pass for InValid data");
	}
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	  ExcelUtils.setExcelFile(Constant.filename,"Register");
	  driver= new ChromeDriver();
	  driver.get("https://frontend.nopcommerce.com/");
	  driver.switchTo().frame(0);
	  hp=new HomePage(driver);
	  rp=new RegisterPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.close();
	 report.flush();
  }
  @BeforeClass
  public void beforeClass() {
  reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report1.html");
  reporter.config().setTheme(Theme.DARK);
  reporter.config().setDocumentTitle("SampleReport");
  reporter.config().setReportName("FunctionalTest Report");
  report = new ExtentReports();
  report.attachReporter(reporter);
  }
}
