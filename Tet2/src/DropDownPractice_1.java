import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPractice_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
	    System.out.println(	driver.getTitle());
		Thread.sleep(2000);
		
	/*	//assignment I created
		
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Prafullachandra Brahma");
		//using parent to child xpath- //div[@class='form-group'] //input[@class='form-control ng-pristine ng-invalid ng-touched']
		
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("prafullachandrabrahma123@gmail.com");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Prafullachandra@123");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		Assert.assertTrue(true);
		WebElement Element = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select Gender = new Select(Element);
		Gender.selectByVisibleText("Male");
		driver.findElement(By.xpath("//label[text()='Student']")).click();
		Assert.assertTrue(true);
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("05-12-2025");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
		*/
 //Dynamic DropDown Handling
	    
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//a[@text='Chennai (MAA)']")).click();
	     Thread.sleep(2000);
	    driver.findElement(By.linkText("Ahmedabad (AMD)")).click();
	    Assert.assertEquals(driver.findElement(By.linkText("Ahmedabad (AMD)")).getText(), "Ahmedabad (AMD)");
	    
	    driver.findElement(By.cssSelector("[class='ui-state-default ui-state-active']")).click();
	    System.out.println( driver.findElement(By.className("picker-second")).getAttribute("style"));
	    //driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
	    
	    if(driver.findElement(By.className("picker-second")).getAttribute("style").contains("display: block; opacity: 0.5;"))
	    {
	    	System.out.println("isDisabled");
	    	Assert.assertTrue(true);
	    	
	    }
	    else
	    {
	    	System.out.println("isEnabled");
	    	Assert.assertTrue(false);
	    }
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
	    
	  driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(2000);
	    
	   for(int i=1; i < 5; i++)
	   {
	    driver.findElement(By.id("hrefIncAdt")).click();
	   }
	   
	   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	   
	    System.out.println("clicked 4 times [+] to add [5] people");
	    
	    driver.findElement(By.id("btnclosepaxoption")).click();
	    Thread.sleep(2000);
	    
        WebElement CurrencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select Currency = new Select(CurrencyDropdown);
		Currency.selectByIndex(1);
	
	    System.out.println(Currency.getFirstSelectedOption().getText());
	    driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	    Thread.sleep(1000);
	    
	    
	    driver.quit();
	   

	}

}
