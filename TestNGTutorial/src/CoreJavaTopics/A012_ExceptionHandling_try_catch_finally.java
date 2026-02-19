package CoreJavaTopics;

public class A012_ExceptionHandling_try_catch_finally {

	public static void main(String[] args) {

		int a = 6;
		int b = 0;
		
		try {
			int c = a/b;
			//int[] d = new int[6];
			System.out.println(c);
			//System.out.println(d[7]);

		}
		catch(IndexOutOfBoundsException ete) {
			System.out.println("Index Out Of Bounds Exception");

		}
		catch(ArithmeticException et) {
			System.out.println("Arithmetic Exception Error");

		}
		catch(Exception e) {
			System.out.println("General Exception Error");

		}
		finally {
			System.out.println("Finally Index Out Of Bounds Exception");

		}
	}

}
