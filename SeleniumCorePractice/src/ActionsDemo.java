import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Functions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		/* driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		System.out.println("Clicked");
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).contextClick().build().perform();*/
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		Set<String> w =driver.getWindowHandles();
		Iterator <String> m = w.iterator();
		String p = m.next();
		String c = m.next();
		driver.switchTo().window(c);
		
	
				
		System.out.println(driver.findElement(By.cssSelector("[class='im-para red']")).getText());
		String[] s =driver.findElement(By.cssSelector("[class='im-para red']")).getText().split("with");
		String[] sub = s[0].split("at");
		String main = sub[1];
		System.out.println(main);
		driver.switchTo().window(p);
		driver.findElement(By.id("username")).sendKeys(main);
		
		

	}

}
