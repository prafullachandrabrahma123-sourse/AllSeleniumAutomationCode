import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
	    System.out.println(	driver.getTitle());
		Thread.sleep(2000);
		WebElement Dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select Element = new Select(Dropdown);
		Element.selectByIndex(3);
		System.out.println(Element.getFirstSelectedOption().getText());
		Element.selectByVisibleText("INR");
		System.out.println(Element.getFirstSelectedOption().getText());
		Element.selectByValue("AED");
		System.out.println(Element.getFirstSelectedOption().getText());
				
		
		//driver.quit();
		
	}

}
