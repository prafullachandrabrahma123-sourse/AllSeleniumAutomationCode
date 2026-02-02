package SeleniumAutomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import SeleniumAutomation.pageobjects.LandingLoginPage;



public class StandAloneTest {

	@Test
		public void StandAloneTest1() throws InterruptedException{
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingLoginPage loginPage = new LandingLoginPage(driver);
		
		
		driver.findElement(By.id("userEmail")).sendKeys("prafullachandrabrahma@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Prafulla@123");
		driver.findElement(By.id("login")).click();
		
		
		List<String>itemNeeded = Arrays.asList("ZARA COAT 3","ADIDAS ORIGINAL");
		
		/* List<WebElement> AllItems = driver.findElements(By.xpath("//h5/b"));
		
		
		 int j=0;
		
		 for(int i = 0; i<AllItems.size();i++) {

			String avlItem = AllItems.get(i).getText();
			System.out.println(avlItem);
			List<String> item = Arrays.asList(itemNeeded);
			if(item.contains(avlItem));
			{
				Thread.sleep(3000);
				driver.findElements(By.xpath("//button[@class='btn w-10 rounded'] //i[@class='fa fa-shopping-cart']")).get(i).click();
			}
			if(j == itemNeeded.length) {
				
				break;
			}
		 }*/
		
		 /* WebElement el =AllItems.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		   
		el.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();  */
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		for(int i=0;i<itemNeeded.size();i++) {
	
		
		//for(String item : itemNeeded) {
			
		WebElement el =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='py-2 border-bottom ml-3']/input[@formcontrolname='productName']")));
		//WebElement el =driver.findElement(By.xpath("//div[@class='py-2 border-bottom ml-3']/input[@formcontrolname='productName']"));
		
		el.clear();
		Thread.sleep(3000);
		el.sendKeys(itemNeeded.get(i)+Keys.ENTER);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5/b")));
		el.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		}
		ArrayList<String> allEl = new ArrayList<String>();
		
		driver.findElement(By.cssSelector("button[class='btn btn-custom'] i[class='fa fa-shopping-cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']")));
		List<WebElement> cartProducts =driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		for(int j=0;j<cartProducts.size();j++) {
		 String cp = cartProducts.get(j).getText();
		 allEl.add(cp);
			}
		
		System.out.println(allEl);
		Assert.assertEquals(allEl, itemNeeded);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Checkout']"))));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='payment']/div[@class='payment__title']"))));
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		driver.findElement(By.xpath("//*[text()=' India']")).click();
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/a[@class='btnn action__submit ng-star-inserted']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String afterSubmit =driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(afterSubmit);
		Assert.assertTrue(afterSubmit.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();

		
		
	}
	

}
