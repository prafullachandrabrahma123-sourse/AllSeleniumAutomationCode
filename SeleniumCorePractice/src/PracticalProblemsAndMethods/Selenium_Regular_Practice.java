package PracticalProblemsAndMethods;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Regular_Practice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Amazon.in']")));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Tables For Home");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-suggestion-container']")));
		driver.findElement(By.xpath("//div[@aria-label='study tables for home']")).click();

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.SPACE).build().perform();
		act.sendKeys("with storage").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

		String[] items = {"Pen", "Book"};
		List<String> list = Arrays.asList(items);

		
		for(int i=0; i<list.size();i++) {
			WebElement el= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			el.clear();
			el.sendKeys(list.get(i));
			act.sendKeys(Keys.ENTER).build().perform();
			

		}
		
		
	}

}
