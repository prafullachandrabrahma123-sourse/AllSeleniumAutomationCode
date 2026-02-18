package ExtentReports.ExtentReports;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void configPath() {
		//ExtentReports  and  //ExtentSparkReporter
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Testing Demo");
		reporter.config().setDocumentTitle("Testing Demo");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prafulla");
		
		
	}
	
	@Test
	public void initialDemo() {
		
	    test = extent.createTest("Initial Demo");
		 driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		
	}
	@AfterTest
    public void tearDown() {
        extent.flush(); // VERY IMPORTANT
        driver.quit();
    }
	

}


