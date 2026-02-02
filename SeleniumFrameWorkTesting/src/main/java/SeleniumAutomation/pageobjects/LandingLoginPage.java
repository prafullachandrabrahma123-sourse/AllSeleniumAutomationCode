package SeleniumAutomation.pageobjects;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class LandingLoginPage {
	
	WebDriver driver;
	
	
	public LandingLoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		System.out.println("Driver in POM: " + driver);
	}
	ExtentTest test;
	ExtentReports repo = ExtentTheReports.configPath();
	
	
	               // driver.findElement(By.id("userEmail")).sendKeys("prafullachandrabrahma@gmail.com");
	                 //driver.findElement(By.id("userPassword")).sendKeys("Prafulla@123");
	                 //driver.findElement(By.id("login")).click();
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userPassword;
		
		@FindBy(id="login")
		WebElement userLogin;
		
		@FindBy(css="button[class='btn btn-custom'] i[class='fa fa-shopping-cart']")
		WebElement cartClick;
		
		@FindBy(xpath="//div[@class='cartSection']//h3")
		List<WebElement> allCartProducts;
		
		@FindBy(xpath="//button[text()='Checkout']")
		WebElement checkOutButton;
		
		@FindBy(xpath="//input[@placeholder='Select Country']")
		WebElement selectCountry;
		
		@FindBy(xpath="//*[text()=' India']")
		WebElement clickOnCountryName;
		
		@FindBy(xpath="//div/a[@class='btnn action__submit ng-star-inserted']")
		WebElement clickSubmitButton;
		
		@FindBy(css=".hero-primary")
		WebElement successText;
		
		@FindBy(css="i[class='fa fa-handshake-o']")
		WebElement clickOnOrder;
		
		@FindBy(xpath="//td[2]")
		List<WebElement> allOrderedProducts;
		
		public void LoginApplication(String userName, String password) {
			userEmail.sendKeys(userName);
			userPassword.sendKeys(password);
			userLogin.click();
			

		}
		
		public void Navigateurl() {
			driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		}
		
		public void maximizeAndWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		
		public void visibilityOfHeading() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5/b")));
		}
		
		public WebElement visibilityOfProduct() {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='py-2 border-bottom ml-3']/input[@formcontrolname='productName']")));
			return el;
			
		}
		
		public void waitForelementAdded() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		}
		
		public void waitForcartSectionElements() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']")));
		}
		
		public void waitForcheckOutButton() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Checkout']"))));
		}
		
		public void paymentPage() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='payment']/div[@class='payment__title']"))));
		}
		
		public void afterOrderPlacedScreen() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		}
		
		public void javascriptExecutorToDown() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,800)");
			//window.scrollTo(0,0)
		}
		public void javascriptExecutorToUp() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,0)");
			//window.scrollBy(0,800)
		}
		
		
		public void clickAddToCart() {
			visibilityOfProduct().findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		}
		public void clearSearchBox() {
			visibilityOfProduct().clear();
		}
		public void clickOnCart() {
			cartClick.click();
		}
		public List<WebElement> cartProducts() {
			List<WebElement> cartProducts = allCartProducts;
			return cartProducts;
		}
		public void clickOnCheckOutButton() {
			checkOutButton.click();
		}
		public void giveCountryName() {
			selectCountry.sendKeys("India");
		}
		public void selectCountryName() {
			clickOnCountryName.click();
		}
		public void clickPlaceOrderButton() {
			clickSubmitButton.click();
		}
		public String extractSuccessText() {
			String afterSubmit =successText.getText();
			return afterSubmit;
		}
		public void clickOrder() {
			clickOnOrder.click();
		}
		public void orderPageProducts() {
			List<String>allOrdProducts =allOrderedProducts.stream().map(s->s.getText()).collect(Collectors.toList());
			//allOrdProducts.forEach(s->System.out.println(s));
			
		}
		
		public void closeBrowser() {
			if (driver != null) {
			driver.quit();
			}
		}
		@FindBy(css="*[class='fa fa-sign-out']")
		WebElement clickSignout;
		
		public void clickSignOutButton() {
			//driver.findElement(By.cssSelector("*[class='fa fa-sign-out']")).click();
			clickSignout.click();
		}
		
	

}
