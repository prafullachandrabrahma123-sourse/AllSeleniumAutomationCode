package CoreJavaTopics;

public class PS3 extends PS4{
	
	int a;
	
	public PS3(int a) {
		
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
