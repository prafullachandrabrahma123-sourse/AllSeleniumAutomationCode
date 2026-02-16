import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AlertPractice {
		
		
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
		    System.out.println(	driver.getTitle());
			Thread.sleep(2000);
			
			
			driver.findElement(By.id("name")).sendKeys("Prafulla");
			driver.findElement(By.id("alertbtn")).click();
			Thread.sleep(1000);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.findElement(By.id("name")).sendKeys("Prafulla");
			driver.findElement(By.id("confirmbtn")).click();
			Thread.sleep(1000);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().dismiss();
			Thread.sleep(1000);
			driver.findElement(By.id("confirmbtn")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();

		}

}
