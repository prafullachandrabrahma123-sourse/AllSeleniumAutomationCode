package PracticalProblemsAndMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) throws IOException {
		
		

		/*FirefoxOptions opt1 = new FirefoxOptions();
		opt1.setAcceptInsecureCerts(true);
		WebDriver driver1 = new FirefoxDriver(opt1);
		driver1.get("https://expired.badssl.com/");
		System.out.println(driver1.getTitle());
		
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());  */
		
		EdgeOptions opt2 = new EdgeOptions();
		opt2.setAcceptInsecureCerts(true);
		WebDriver driver2 = new EdgeDriver(opt2);
		driver2.get("https://expired.badssl.com/");
		System.out.println(driver2.getTitle());
		
		File src = ((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\WEL COME\\Desktop\\SeleniumScreenshots\\screenshot.png"));
		
	

	}

}
