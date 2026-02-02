package CucumberBDD.tests;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersAs extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports report = ExtentReportsBDD.config();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		  try {
	            String Path = TakesScreenshot(
	                    result.getMethod().getMethodName(),
	                    driver
	            );
	            extentTest.get().addScreenCaptureFromPath(Path);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
		

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL,"Test Failed");
		 
		try {
		String path =	TakesScreenshot(result.getMethod().getMethodName(), driver);
		extentTest.get().addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
