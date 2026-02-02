package PracticalProblemsAndMethods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/* String url = driver.findElement(By.linkText("broken link")).getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int repocod = conn.getResponseCode();
		System.out.println(repocod);  */ 
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//table//tbody//tr//a"));
		
		 SoftAssert a = new SoftAssert();
	
		
		for(int i=0;i<allLinks.size();i++)
		{
			String all = allLinks.get(i).getAttribute("href");
			
			HttpURLConnection con = (HttpURLConnection) new URL(all).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int repoCode = con.getResponseCode();
			System.out.println(repoCode);
			a.assertTrue(repoCode<400, "The Broken Link is "+allLinks.get(i).getText()+ " is Broken with Link " + repoCode);
			
			
		}
		
		a.assertAll();  
		
		
		/*   SoftAssert sa = new SoftAssert();

		allLinks.stream()
		    .map(e -> e.getAttribute("href"))
		    .forEach(url -> {
		        try {
		            HttpURLConnection con =
		                (HttpURLConnection) new URL(url).openConnection();
		            con.setRequestMethod("HEAD");
		            con.connect();
		            int code = con.getResponseCode();
		            sa.assertTrue(code < 400,
		                    "Broken link: " + url + " | Code: " + code);
		        } catch (Exception e) {
		            sa.fail("Broken link: " + url + " | Exception occurred");
		        }
		    });

		sa.assertAll();   */

	}

}
