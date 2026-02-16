import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/*
		driver.get("https://jqueryui.com/droppable/");
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("[id='draggable']")).click();
		Actions a = new Actions(driver);
		//WebElement s = driver.findElement(By.cssSelector("[id='draggable']"));
		//WebElement t = driver.findElement(By.cssSelector("[id='droppable']"));
		a.dragAndDrop(driver.findElement(By.cssSelector("[id='draggable']")),driver.findElement(By.cssSelector("[id='droppable']"))).build().perform();
		*/
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-top']")));
		
	    driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-middle']")));
	    System.out.println(driver.findElement(By.id("content")).getText());
	    //driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
	    
	   // System.out.println(driver.findElement(By.tagName("body")).getText());
	    
	    

	}

}

