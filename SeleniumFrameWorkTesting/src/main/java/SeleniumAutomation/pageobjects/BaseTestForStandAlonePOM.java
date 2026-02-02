package SeleniumAutomation.pageobjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTestForStandAlonePOM {
	

	 protected WebDriver driver;

	    @BeforeTest
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	        System.out.println("Driver in setup: " + driver);
	        
	    }
	
	//private static WebDriver driver;
	public String takesScreenShot(WebDriver driver, String testName) throws IOException {
		 if (driver == null) {
	            System.out.println("Driver is null, screenshot skipped");
	            return null;
	        }
		   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(src, new File(System.getProperty("user.dir")+ "\\reports\\"+testName+".png"));
		      return System.getProperty("user.dir")+ "\\reports\\"+testName+".png";
	}

}
