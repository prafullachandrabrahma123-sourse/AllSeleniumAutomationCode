package CoreJavaTopics;

import org.testng.annotations.Test;

public class A002_SeleniumPart extends A001_SeleniumPart {

	@Test
	public void cars() {
		
		vehicle();
		
		int a =3;
		
		A003_SeleniumPart a003_SeleniumPart = new A003_SeleniumPart(a); //Constructor 
		A004_SeleniumPart a004_SeleniumPart = new A004_SeleniumPart(a);
		//ps3.incrementAs();
		
		System.out.println(a003_SeleniumPart.incrementAs());
		System.out.println(a003_SeleniumPart.decrementAs());
		//System.out.println(ps3.multiplyByTwo());
		System.out.println(a003_SeleniumPart.multiplyByThree());

	}

}
