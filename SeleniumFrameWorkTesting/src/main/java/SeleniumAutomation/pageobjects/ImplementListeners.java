package SeleniumAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ImplementListeners extends BaseTestForStandAlonePOM  implements ITestListener {
	

	ExtentTest test;
	ExtentReports repo = ExtentTheReports.configPath();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		test =repo.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Passed");
		  String filePath = null;

		    try {
		        Object testClass = result.getInstance();
		        BaseTestForStandAlonePOM baseTest =
		                (BaseTestForStandAlonePOM) testClass;

		        WebDriver driver = baseTest.driver;

		        filePath = baseTest.takesScreenShot(driver,result.getMethod().getMethodName());
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    // ✅ Use filePath ONLY after assignment
		    if (filePath != null) {
		        test.addScreenCaptureFromPath(
		                filePath,
		                result.getMethod().getMethodName()
		        );
		    }
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);

	    test.log(Status.FAIL, "Test Failed");
	    test.fail(result.getThrowable());

	    String filePath = null;

	    try {
	        Object testClass = result.getInstance();
	        BaseTestForStandAlonePOM baseTest =
	                (BaseTestForStandAlonePOM) testClass;

	        WebDriver driver = baseTest.driver;

	        filePath = baseTest.takesScreenShot(driver,result.getMethod().getMethodName());
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // ✅ Use filePath ONLY after assignment
	    if (filePath != null) {
	        test.addScreenCaptureFromPath(
	                filePath,
	                result.getMethod().getMethodName()
	        );
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		//test.fail(result.getThrowable());
		test.skip(result.getThrowable());
		  String filePath = null;

		    try {
		        Object testClass = result.getInstance();
		        BaseTestForStandAlonePOM baseTest =
		                (BaseTestForStandAlonePOM) testClass;

		        WebDriver driver = baseTest.driver;

		        filePath = baseTest.takesScreenShot(driver,result.getMethod().getMethodName());
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    // ✅ Use filePath ONLY after assignment
		    if (filePath != null) {
		        test.addScreenCaptureFromPath(
		                filePath,
		                result.getMethod().getMethodName()
		        );
		    }
		    
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		repo.flush();
	}

}

