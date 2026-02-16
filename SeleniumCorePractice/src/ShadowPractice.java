import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://adbtest.service-now.com/login.do");
		Thread.sleep(3000);
		//driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys("MMI");
	    driver.findElement(By.name("user_password")).sendKeys("P@ssw0rd");
	    driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	    Thread.sleep(5000);
	    
		WebElement parent = driver.findElement(By.cssSelector("macroponent-f51912f4c700201072b211d4d8c26010"));
		
		SearchContext child1 = parent.getShadowRoot();
		System.out.println("Printed");
		WebElement child2 = child1.findElement(By.cssSelector("sn-canvas-appshell-root:nth-child(1)"));
		SearchContext child3 = parent.getShadowRoot();
		System.out.println("Printed");
		WebElement child4 = child1.findElement(By.cssSelector("sn-canvas-appshell-layout:nth-child(1)"));
		SearchContext child5 = parent.getShadowRoot();
		System.out.println("Printed");
		WebElement child6 = child1.findElement(By.cssSelector("sn-polaris-layout:nth-child(1)"));
		SearchContext child7 = child6.getShadowRoot();
		System.out.println("Printed");
		WebElement child8 = child7.findElement(By.cssSelector("sn-polaris-header"));
		SearchContext child9 = child8.getShadowRoot();
		System.out.println("Printed");
		WebElement child10 = child9.findElement(By.cssSelector("sn-polaris-menu[aria-label='More menus']"));
		SearchContext child11 = child10.getShadowRoot();
		System.out.println("Printed");
		WebElement allBtn = child9.findElement(By.cssSelector("div[aria-label='All']"));
		allBtn.click();
		Thread.sleep(3000);
		System.out.println("Clicked");
		
		driver.get("https://adbtest.service-now.com/esc_hr");
		driver.manage().window().maximize();
		
		
		Thread.sleep(3000);
		
	}

}
