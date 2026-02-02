import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] elem = {"6","15","2027"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//button[@class='react-date-picker__clear-button react-date-picker__button']")).click();
	    driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__month']")).sendKeys("06");
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__day']")).sendKeys("15");
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__year']")).sendKeys("2027");
		driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
	    //System.out.println(driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']//input[@name='date']")).getText());
	    List<WebElement> all= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
	
	    for(int i=0;i<all.size();i++)
	    {
	    	String el = all.get(i).getAttribute("value");
	    	System.out.println(el);
	    	Assert.assertEquals(el, elem[i]);
	    }
		

	}

}
