package StepDefinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import CucumberBDD.pageobject.LandingPage;
import CucumberBDD.tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImplementation extends BaseTest {

	public LandingPage land;

	@Given("I landed on loginPage")
	public void I_landed_on_loginPage() {
		land = openWindow();

	}

	@Given("^Logged in with userName(.+) and password(.+)$")
	public void Logged_in_with_userName_and_password(String userName, String password) {
		land.userDataEnterAndClickLogin(userName, password);
	}

	@When("^i added products (.+)from cart$")
	public void i_added_products_from_cart(String productName) throws InterruptedException {
		List<String> itemNeeded = Arrays.asList(productName);

		for (int i = 0; i < itemNeeded.size(); i++) {
			WebElement el = land.waitForProducts();
			el.clear();
			Thread.sleep(3000);
			el.sendKeys(itemNeeded.get(i) + Keys.ENTER);
			Thread.sleep(3000);
			land.waitForAllElements();
			el.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
			land.waitForMessage();

		}

	}
	@Then  ("^check(.+)is present")
	public void  check_product_is_present (String productName) {
		ArrayList<String> allEl = new ArrayList<String>();

		land.clickOnCart();
		land.waitForCartElement();
		List<WebElement>cartProducts=land.collectElementsIntoList();
		for (int j = 0; j < cartProducts.size(); j++) {
			String cp = cartProducts.get(j).getText().replaceAll("\\s+", " ").trim();
			allEl.add(cp);
		}

		System.out.println(allEl);
		Assert.assertEquals(allEl, Collections.singletonList(productName.trim()));

	}

}
