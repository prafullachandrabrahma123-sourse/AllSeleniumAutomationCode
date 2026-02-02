import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowsActivity {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		WebElement element = driver.findElement(By.cssSelector("div[class=\"H6-NpN _3N4_BX\"]"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(2000);
		element.click();
		Thread.sleep(2000);

	}

}
