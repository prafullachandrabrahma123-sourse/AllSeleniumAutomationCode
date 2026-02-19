package CoreJavaTopics;

public class A008_AbstractClassImplementation extends A008_AbstractClass{

	public static void main(String[] args) {

		A008_AbstractClassImplementation test = new A008_AbstractClassImplementation();
		test.redColour();
		test.yellowColour();
		test.greenColour();

	}

	@Override
	public void greenColour() {
		// TODO Auto-generated method stub
		System.out.println("And Go");

	}

}
