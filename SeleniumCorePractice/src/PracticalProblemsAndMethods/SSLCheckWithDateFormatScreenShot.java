package PracticalProblemsAndMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class SSLCheckWithDateFormatScreenShot {

	public static void main(String[] args) throws IOException {
		
		

		/*FirefoxOptions opt1 = new FirefoxOptions();
		opt1.setAcceptInsecureCerts(true);
		WebDriver driver1 = new FirefoxDriver(opt1);
		driver1.get("https://expired.badssl.com/");
		System.out.println(driver1.getTitle());*/
		
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());  
		
		/* EdgeOptions opt2 = new EdgeOptions();
		opt2.setAcceptInsecureCerts(true);
		WebDriver driver2 = new EdgeDriver(opt2);
		driver2.get("https://expired.badssl.com/");
		System.out.println(driver2.getTitle());  */
		
		File directory = new File("C:\\\\Users\\\\WEL COME\\\\Desktop\\\\SeleniumScreenshots\\Test\\");

        // Step 2: Check if folder exists, if not create it
        if (!directory.exists()) {
            directory.mkdirs();  // creates folder + parent folders
        }
		
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss");
		String t = sd.format(date);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(directory,t+".png"));
		driver.quit();
		
	

	}

}
