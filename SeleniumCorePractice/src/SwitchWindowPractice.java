import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchWindowPractice {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> i = window.iterator();
		String mainW = i.next();
		String child = i.next();
		driver.switchTo().window(child);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(mainW);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());

	}

}
