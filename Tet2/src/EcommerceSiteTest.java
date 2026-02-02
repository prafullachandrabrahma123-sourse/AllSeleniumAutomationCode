import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceSiteTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		

		String[] itemNeed = { "Cucumber", "Beetroot" };
		cartItems(driver, itemNeed );
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		driver.quit();



		/*
		 * 
		 * driver.findElement(By.
		 * cssSelector("[placeholder='Search for Vegetables and Fruits']")).sendKeys(
		 * "Cucumber"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		 * driver.findElement(By.
		 * cssSelector("[placeholder='Search for Vegetables and Fruits']")).clear();
		 * Thread.sleep(2000); driver.findElement(By.
		 * cssSelector("[placeholder='Search for Vegetables and Fruits']")).sendKeys(
		 * "Brocolli");
		 * driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		 * driver.findElement(By.cssSelector("[alt='Cart']")).click();
		 * System.out.println(driver.findElement(By.cssSelector("ul[class='cart-items']"
		 * )).getText()); // driver.navigate().refresh(); driver.quit();
		 * 
		 */

	}
	
	public static void cartItems(WebDriver driver,String[] itemNeed ) throws InterruptedException {
	
	List<WebElement> allItems = driver.findElements(By.cssSelector("h4[class='product-name']"));
	int j = 0;

	for (int i = 0; i < allItems.size(); i++) {
		String[] items = allItems.get(i).getText().split("-");
		String item = items[0].trim();
		List Product = Arrays.asList(itemNeed);

		if (Product.contains(item)) {
			driver.findElements(By.xpath("//div[@class='product-action'] //button[@type='button']")).get(i).click();
			
			
		}
		if(j==itemNeed.length)
		{
			break;
		}
		
		
	}
	System.out.println("Got the products");
	

	}

}
