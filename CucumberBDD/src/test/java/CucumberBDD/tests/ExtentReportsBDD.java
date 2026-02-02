package CucumberBDD.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBDD {
	
	
	public static ExtentReports config() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
	
	ExtentSparkReporter report = new ExtentSparkReporter(path);
	report.config().setReportName("BDD Reports");
	report.config().setDocumentTitle("BDD Reports");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester", "PRAFULLACHANDRA BRAHMA");
	return extent;
	
	}

}
