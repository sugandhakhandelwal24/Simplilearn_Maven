package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	XSSFWorkbook wbook;
    XSSFSheet sheet;
	
	SoftAssert softassert = new SoftAssert();
	
	//@BeforeGroups("Regression")
	@BeforeMethod
	public void setup() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		report = new ExtentReports("ExtentReports.html");
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
        
        wbook = new XSSFWorkbook(fis);
        
        sheet = wbook.getSheetAt(0);
	}
	
	//@AfterGroups("Regression")
	@AfterMethod
	public void TearDown()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
		softassert.assertAll();
	}


}
