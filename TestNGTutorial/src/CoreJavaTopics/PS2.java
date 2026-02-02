package CoreJavaTopics;

import org.testng.annotations.Test;

public class PS2 extends PS1 {

	@Test
	public void cars() {
		
		vehicle();
		
		int a =3;
		
		PS3 ps3 = new PS3(a); //Constructor 
		PS4 ps4 = new PS4(a);
		//ps3.incrementAs();
		
		System.out.println(ps3.incrementAs());
		System.out.println(ps3.decrementAs());
		//System.out.println(ps3.multiplyByTwo());
		System.out.println(ps3.multiplyByThree());

	}

}
