import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsAsTraverseXpath {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//button[text()=\"Login\"]")).getText());
		Thread.sleep(2000);

		driver.quit();
		
	}

}
