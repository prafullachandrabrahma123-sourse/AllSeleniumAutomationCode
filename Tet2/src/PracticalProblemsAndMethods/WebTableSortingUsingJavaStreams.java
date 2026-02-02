package PracticalProblemsAndMethods;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingUsingJavaStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("[aria-label='Veg/fruit name: activate to sort column ascending']")).click();

		List<WebElement> allElements = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = allElements.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertEquals(originalList, sortedList);
		
		
		
		List<String> pValue;

		// print the price of the Beans
		do {
			List<WebElement> allElements1 = driver.findElements(By.xpath("//tr/td[1]"));
			pValue= allElements1.stream().filter(s -> s.getText().contains("Cherry"))
				.map(s -> getPriceOfVeggie(s)).collect(Collectors.toList());
		pValue.forEach(s -> System.out.println(s));
		//System.out.println(pValue);
		if(pValue.size()<1) {
			
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(pValue.size()<1);
		
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("Rice");
		search.sendKeys(Keys.ENTER);
		String actual =search.getAttribute("value");
		System.out.println(actual);
		List<WebElement> text = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> text1 =text.stream().filter(s->s.getText().contains("R")).collect(Collectors.toList());
		//text1.forEach(s->System.out.println(s));
		System.out.println(text.size());
		System.out.println(text1.size());
		Assert.assertEquals(text.size(), text1.size());
		
		
	}

	private static String getPriceOfVeggie(WebElement s) {
		String PriceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return PriceValue;
	}

}
