import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Locator_Practice {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("Prafulla");
	    driver.findElement(By.name("inputPassword")).sendKeys("Prafulla@123");
		driver.findElement(By.className("submit")).click();
	  WebElement element = driver.findElement(By.linkText("Forgot your password?"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		element.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prafulla");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("prafullachandrabrahma123@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9515185544");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		Thread.sleep(5000);
		
	    System.out.println(driver.findElement(By.className("error")).getText());
		System.out.println(driver.findElement(By.className("infoMsg")).getText());
		System.out.println(driver.getCurrentUrl());
		 
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Prafulla");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//label[@for='chkboxOne']")).click();
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        Thread.sleep(5000);
		 
		 //cssSelector("p.error")
		 driver.quit();
	}
}

 
