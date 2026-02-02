package PracticalProblemsAndMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class JavaScriptUsage {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		System.out.println("ScrolledToTheParticularTable");
		
		

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=200");

		System.out.println("ScrolledTheTableToDown");
		File sr =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sr, new File("C:\\Users\\WEL COME\\Desktop\\SeleniumScreenshots\\screenshot.png"));

		List<WebElement> amountValues = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));

		int sum = 0;

		for (int i = 0; i < amountValues.size(); i++) {

			int s = Integer.parseInt(amountValues.get(i).getText());

			sum = sum + s;

		}

		System.out.println(sum);

		int actualTotal = Integer

				.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());

		System.out.println(actualTotal);

		Assert.assertEquals(sum, actualTotal);

		/*
		 * 
		 * List<WebElement> total =
		 * 
		 * driver.findElements(By.xpath("//div[@class='totalAmount']"));
		 *
		 * 
		 * 
		 * for(int j =0;j<total.size();j++) { String[] t1 =
		 * 
		 * total.get(j).getText().split(":"); String actualTotal1 = t1[1].trim();
		 * 
		 * System.out.println(actualTotal1); int actualTota2 =
		 * 
		 * Integer.parseInt(actualTotal1); Assert.assertEquals(sum, actualTota2);
		 *
		 * 
		 * 
		 * }
		 * 
		 */

		int rowsPresent = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();

		System.out.println(rowsPresent);

		int columnsPresent = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();

		System.out.println(columnsPresent);

		WebElement content = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));

		System.out.println(content.getText());

		driver.findElement(By.cssSelector("[class='inputs ui-autocomplete-input']")).sendKeys("ind");

		WebElement el = driver.findElement(By.xpath("//ul//div[text()='India']"));
		Actions act = new Actions(driver);
		act.moveToElement(el).build().perform();
		Thread.sleep(2000);
		el.click();
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File("C:\\Users\\WEL COME\\Desktop\\SeleniumScreenshots\\screenshot1.png"));
		
		

		/*Thread.sleep(2000);

		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));*/

	}

}