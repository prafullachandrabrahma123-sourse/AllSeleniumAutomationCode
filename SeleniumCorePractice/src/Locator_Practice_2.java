import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Locator_Practice_2 {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("inputUsername")).sendKeys("Prafulla");
	
		String Password = getPassword(driver);
		
		
		WebElement element = driver.findElement(By.name("inputPassword"));
		element.sendKeys(Password);
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//label[@for='chkboxOne']")).click();
	    Thread.sleep(2000);
		driver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
		
				
	    System.out.println(	driver.findElement(By.tagName("p")).getText());
	    Thread.sleep(2000);
	    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
	    driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
	    Thread.sleep(2000);
	    System.out.println(driver.findElement(By.cssSelector("[class=\"form\"] h1")).getText() + " Page [Backed to login Page]");
	    
	    driver.quit();
	   
	}
	
	public static String  getPassword(WebDriver driver) throws InterruptedException {
		//driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		Thread.sleep(2000);
		 String Password1 = driver.findElement(By.className("infoMsg")).getText();
		 driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		 Thread.sleep(2000);
		String[] Password2 = Password1.split("'");
		String[] Password3 = Password2[1].split("'");
		String Password = Password3[0];
		return Password;
		
	}
}
