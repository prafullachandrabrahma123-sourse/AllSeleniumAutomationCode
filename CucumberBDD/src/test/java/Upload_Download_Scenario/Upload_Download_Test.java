package Upload_Download_Scenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Upload_Download_Test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.findElement(By.id("downloadButton")).click();
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:\\Users\\WEL COME\\Downloads\\download.xlsx");
		
		By text = By.xpath("//div[text()='Updated Excel Data Successfully.']");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Updated Excel Data Successfully.']")));
		//wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[text()='Updated Excel Data Successfully.']"),"Updated Excel Data Successfully."));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(text));
	    String eText = driver.findElement(text).getText();
	    System.out.println(eText);
		//Thread.sleep(3000);
		Assert.assertEquals("Updated Excel Data Successfully.", eText);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(text));
		System.out.println(driver.findElement(By.xpath("//div[@id='row-1']//div[@data-column-id='4']")).getText());
		driver.quit();

	}

}
