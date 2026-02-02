package TestNGTutorialPractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A_1_RunWithOutJava {
	
	@Test(groups={"Smoke"})
	public void a1demo() {
		
		System.out.println("1");
	}
	
	
	@Parameters( {"URL","username"})
	@Test
	public void a2Personalloan(String url,String uname) {
		
		System.out.println("2");
		System.out.println(url);
		System.out.println(uname);
	}
	@Test(timeOut=4000)
	public void a3CarLoan() {
		
		System.out.println("3");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods= {"a3CarLoan"})
	public void a4HomeLoan() {
		
		System.out.println("4");
	}
	
	@Test(priority=1)
	public void a5Goldloan() {
		
		System.out.println("5");
	}

}
