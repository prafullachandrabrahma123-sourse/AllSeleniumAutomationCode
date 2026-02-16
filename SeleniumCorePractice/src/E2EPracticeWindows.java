import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EPracticeWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// 1. Getting all the links on the page
		// 2. Only bottom page links were Identified

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
		
		driver.findElement(By.id("checkBoxOption2")).click();
		System.out.println(driver.findElement(By.cssSelector("[for='benz']")).getText());
		String name = driver.findElement(By.cssSelector("[for='benz']")).getText();
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(dropDown);
		sel.selectByContainsVisibleText(name);
		
		driver.findElement(By.name("enter-name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		 System.out.println(driver.switchTo().alert().getText());
		 String alrtval = driver.switchTo().alert().getText();
		 String[] act = alrtval.split(",");
		 String[] splt = act[0].split(" ");
		 String actsplt = splt[1];
		 System.out.println(actsplt);
		 
		 Assert.assertEquals(name, actsplt);
		
		
		/*
		System.out.println(driver.findElements(By.tagName("a")).size());
		String clicks = Keys.chord(Keys.CONTROL,Keys.ENTER);

		WebElement below = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(below.findElements(By.tagName("a")).size());// Limiting WebDriver Scope

		WebElement sc = below.findElement(By.tagName("ul"));
		System.out.println(sc.findElements(By.tagName("a")).size());
		
		for(int i = 1; i<sc.findElements(By.tagName("a")).size();i++ )
		{
			sc.findElements(By.tagName("a")).get(i).sendKeys(clicks);
			
		}
			
			Set<String> win = driver.getWindowHandles();
			Iterator<String> it = win.iterator();
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}*/
		
		
		
			
			
			
			
		}
		
	

	}


