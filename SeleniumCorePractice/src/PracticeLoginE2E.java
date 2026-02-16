import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeLoginE2E {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		// Disable Chrome password manager + save password prompts
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		// Specifically disable leak detection ("Change your password" dialog)
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		// Optional but often used
		options.addArguments("--password-store=basic");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		System.out.println("Clicked");
		WebElement dropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(dropDown);
		select.selectByValue("stud");
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shop")));

		Wait<WebDriver> r = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement m = r.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.linkText("Shop")).isDisplayed()) {
					return driver.findElement(By.linkText("Shop"));
				} else {
					return null;
				}
			}
		});



		Thread.sleep(6);
		Actions action = new Actions(driver);
		action.moveToElement(m);
		Thread.sleep(3);

		System.out.println(driver.findElement(By.linkText("Shop")).getText());
		String[] itemsNeeded = { "iphone X", "Blackberry", "Nokia Edge" };

		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='card-title']"));

		for (int i = 0; i < products.size(); i++) {
			String items = products.get(i).getText();
			List<String> asItem = Arrays.asList(itemsNeeded);
			if (asItem.contains(items)) {
				driver.findElements(By.xpath("//div[@class='card-footer'] //button[@class='btn btn-info'] ")).get(i)
						.click();
			}

		}

		// driver.quit();
		


	}

}
