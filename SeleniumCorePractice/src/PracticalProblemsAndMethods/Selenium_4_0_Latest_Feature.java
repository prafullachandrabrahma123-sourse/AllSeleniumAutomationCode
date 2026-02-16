package PracticalProblemsAndMethods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;


public class Selenium_4_0_Latest_Feature {

	
	
		WebDriver driver = new ChromeDriver();
		
		//@Test
		public void NavigateByPlace() {
		 
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
	  WebElement above = driver.findElement(By.cssSelector("[name='name']"));
	System.out.println(driver.findElement(with(By.tagName("label")).above(above)).getText());
	
	WebElement below = driver.findElement(By.cssSelector("[for='dateofBirth']"));
	
	//unfortunately it will click the below to below, because the immediate below is under flex !
	driver.findElement(with(By.tagName("input")).below(below)).click();
	
	WebElement left = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
	driver.findElement(with(By.tagName("input")).toLeftOf(left)).click();
	
	WebElement right = driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));
	driver.findElement(with(By.tagName("input")).toRightOf(right)).click();  
	
		}
		
		//@Test
		public void urlNavigation() {
			
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.get("https://rahulshettyacademy.com/");
		String text =driver.findElement(By.xpath("//*[text()='Lifetime Access']")).getText();
		driver.navigate().back();
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(text);
		
		}
		
		@Test
		public void openingNewTab() throws IOException {
			
			
		
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://rahulshettyacademy.com/");
			String text =driver.findElement(By.xpath("//*[text()='Lifetime Access']")).getText();
			Set<String> wind = driver.getWindowHandles();
			Iterator<String> it = wind.iterator();
			String main = it.next();
		    driver.switchTo().window(main);
			WebElement actual =driver.findElement(By.cssSelector("[name='name']"));
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
			WebElement el = wait.until(new Function<WebDriver,WebElement>(){
				public WebElement apply(WebDriver driver) {
					if(driver.findElement(By.cssSelector("[name='name']")).isDisplayed()) {
						return driver.findElement(By.cssSelector("[name='name']"));
					}else {
						return null;
					}
				}
			});
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)");
			actual.sendKeys(text);
			File screen = actual.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("Name.png"));
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("screenshot1.png"));
			
			System.out.println(actual.getRect().getDimension().getHeight());
			System.out.println(actual.getRect().getDimension().getWidth());

			
			
		

	}


}
