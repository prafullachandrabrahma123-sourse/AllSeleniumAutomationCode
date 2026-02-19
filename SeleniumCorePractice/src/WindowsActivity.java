import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsActivity {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Login']")));
		driver.navigate().refresh();
		driver.navigate().back();
		//Thread.sleep(2000);
		driver.navigate().forward();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Login']")));

		WebElement element = driver.findElement(By.xpath("//span[text()='Login']"));
		//Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(2000);
		element.click();
		//Thread.sleep(2000);
		System.out.println("Successfully Clicked");
		driver.quit();

	}

}
