package SeleniumAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumAutomation.pageobjects.BaseTestForStandAlonePOM;
import SeleniumAutomation.pageobjects.LandingLoginPage;

public class StandAloneTest_POM_Implementation extends BaseTestForStandAlonePOM {

	
	List<String> itemNeeded = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL");
	LandingLoginPage loginPage;
	

	@Test( dataProvider = "getData")
	public void addProducts(HashMap<String,String>input) throws InterruptedException {

		//loginPage.maximizeAndWait();
		 //loginPage.Navigateurl();
		loginPage = new LandingLoginPage(driver);
		System.out.println("Driver in test: " + driver);
		
		loginPage.LoginApplication(input.get("email"), input.get("password"));

		for (int i = 0; i < itemNeeded.size(); i++) {
			WebElement el = loginPage.visibilityOfProduct();
			loginPage.clearSearchBox();
			Thread.sleep(2000);
			el.sendKeys(itemNeeded.get(i) + Keys.ENTER);
			Thread.sleep(2000);
			loginPage.visibilityOfHeading();
			loginPage.clickAddToCart();
			loginPage.waitForelementAdded();}
		}
		
		@Test(dependsOnMethods ={"addProducts"},retryAnalyzer=RetryFailedTest.class)
		public void cartElements() throws InterruptedException {

		ArrayList<String> allEl = new ArrayList<String>();
		loginPage.clickOnCart();
		loginPage.waitForcartSectionElements();
		List<WebElement> cartProducts = loginPage.cartProducts();
		for (int j = 0; j < cartProducts.size(); j++) {
			String cp = cartProducts.get(j).getText();
			allEl.add(cp);
		}

		System.out.println(allEl);
		Assert.assertEquals(allEl, itemNeeded);
		Thread.sleep(2000);
		}
		@Test(dependsOnMethods={"cartElements"})
		public void checkOutPage() throws InterruptedException {
		loginPage.waitForcheckOutButton();
		loginPage.javascriptExecutorToDown();
		Thread.sleep(2000);
		loginPage.clickOnCheckOutButton();
		loginPage.paymentPage();
		loginPage.giveCountryName();
		loginPage.selectCountryName();
		loginPage.javascriptExecutorToDown();
		Thread.sleep(2000);
		loginPage.clickPlaceOrderButton();
		loginPage.afterOrderPlacedScreen();
		String afterSubmit = loginPage.extractSuccessText();
		System.out.println(afterSubmit);
		Assert.assertTrue(afterSubmit.equalsIgnoreCase("Thankyou for the order."));
		Thread.sleep(3000);
		loginPage.javascriptExecutorToUp();
		Thread.sleep(3000);
		}
		@Test(dependsOnMethods={"checkOutPage"})
		public void placeOrder() throws InterruptedException {
			
		loginPage.clickOrder();
		Thread.sleep(2000);
		loginPage.javascriptExecutorToUp();
		Thread.sleep(2000);
		loginPage.orderPageProducts();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		

	}

	@AfterTest
	// dependsOnMethods="submitOrder", alwaysRun = true
	public void orderValidationAfterSubmit() throws InterruptedException {
		
		loginPage.clickSignOutButton();
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		loginPage.closeBrowser();

	}

	@DataProvider
	public Object[][] getData() {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "prafullachandrabrahma@gmail.com");
		map.put("password" , "Prafulla@123");
		
		/*HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "prafullachandrabrahma@gmail.com");
		map1.put("password" , "Prafulla@123");
		
		HashMap<String,String> map3 = new HashMap<String,String>();
		map3.put("email", "prafullachandrabrahma@gmail.com");
		map3.put("password" , "Prafulla@123");*/
		return new Object[][] {{map}};
	}

}
