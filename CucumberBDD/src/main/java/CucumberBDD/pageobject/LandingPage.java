package CucumberBDD.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userId;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement loginButton;
	@FindBy(css="button[class='btn btn-custom'] i[class='fa fa-shopping-cart']")
	WebElement clickOnCartButton;
	@FindBy(xpath="//div[@class='cartSection']//h3")
     List<WebElement> products;
	
	
	public void globalURL() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public void implecitWaitAndMaximizeWindow() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	 public void userDataEnterAndClickLogin(String UserName,String Password) {
		 userId.sendKeys(UserName);
		 password.sendKeys(Password);
		 loginButton.click();
	 }
	
	public WebElement waitForProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='py-2 border-bottom ml-3']/input[@formcontrolname='productName']")));
		return el;
	}
	public WebElement waitForAllElements() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5/b")));
		return el;
	}
	public WebElement waitForMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		return el;
	}
	public void clickOnCart() {
		WebElement cl =clickOnCartButton;
		cl.click();
	}
	public WebElement waitForCartElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']")));
		return el;
		
	}
	public List<WebElement> collectElementsIntoList() {
		List<WebElement> cartProducts = products;
		return cartProducts;
		
	}

}
