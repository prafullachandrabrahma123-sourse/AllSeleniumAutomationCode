package CoreJavaTopics;

public class A003_SeleniumPart extends A004_SeleniumPart{
	
	int a;
	
	public A003_SeleniumPart(int a) {
		
		super(a);
		this.a =a;   //this keyword
	}

	public int incrementAs() {
		
		a= a+1;
		return a;
	}
public int decrementAs() {
		
		a= a-1;
		return a;
	}


}
