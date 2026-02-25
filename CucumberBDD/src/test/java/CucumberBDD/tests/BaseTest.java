package CucumberBDD.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import CucumberBDD.pageobject.LandingPage;

import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	protected static WebDriver driver ;
	
	@BeforeTest
	public LandingPage openWindow() {
		
		 driver = new ChromeDriver();
		 LandingPage logpage = new LandingPage(driver);
			logpage.implecitWaitAndMaximizeWindow();
			logpage.globalURL();
			return logpage;

	}
	
	public String TakesScreenshot(String testCaseName,WebDriver driver) throws IOException {
	     File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = System.getProperty("user.dir")
	                + "/reports/" + testCaseName + ".png";
	        FileUtils.copyFile(src, new File(path));
	        return path;
	    }
	@AfterTest(alwaysRun = true)
	public void atLast() {
		  if (driver != null) {
		driver.quit();
	}
  }
}
	

