package CucumberBDD.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CucumberBDD.pageobject.LandingPage;

public class LoginEcommerseSiteTest extends BaseTest {

	@Test
	public void LoginEcommerseSite() throws InterruptedException {

		LandingPage logpage = new LandingPage(driver);
		logpage.userDataEnterAndClickLogin("prafullachandrabrahma@gmail.com", "Prafulla@123");
		List<String> itemNeeded = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL");
		

		for (int i = 0; i < itemNeeded.size(); i++) {
			WebElement el = logpage.waitForProducts();
			el.clear();
			Thread.sleep(3000);
			el.sendKeys(itemNeeded.get(i) + Keys.ENTER);
			Thread.sleep(3000);
			logpage.waitForAllElements();
			el.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
			logpage.waitForMessage();

		}
		ArrayList<String> allEl = new ArrayList<String>();

		logpage.clickOnCart();
		logpage.waitForCartElement();
		List<WebElement>cartProducts=logpage.collectElementsIntoList();
		for (int j = 0; j < cartProducts.size(); j++) {
			String cp = cartProducts.get(j).getText();
			allEl.add(cp);
		}

		System.out.println(allEl);
		Assert.assertEquals(allEl, itemNeeded);

	}

}
