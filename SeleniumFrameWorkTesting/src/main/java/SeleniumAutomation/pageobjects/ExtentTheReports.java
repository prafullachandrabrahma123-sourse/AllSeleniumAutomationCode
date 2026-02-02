package SeleniumAutomation.pageobjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTheReports {
	
	
	public  static ExtentReports configPath() {
	
	String path = System.getProperty("user.dir")+ "\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Testing Demo");
	reporter.config().setDocumentTitle("Testing Demo");
	
	ExtentReports extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Prafulla");
	//ExtentTest test = extent.createTest("StandAloneTest");
	return extent;
	

    }
	
}
