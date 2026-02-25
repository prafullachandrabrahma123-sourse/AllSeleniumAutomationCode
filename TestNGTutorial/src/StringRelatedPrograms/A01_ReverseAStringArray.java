package StringRelatedPrograms;

public class A01_ReverseAStringArray {

	public static void main(String[] args) {

		String[] num = {"Prafulla"};

		for (int i = num.length - 1; i >= 0; i--) {
		    String word = num[i];
		    
		    // Internal loop to print characters of the word backward
		    for (int j = word.length() - 1; j >= 0; j--) {
		        System.out.print(word.charAt(j));
		    }
		    System.out.println(); // Move to next line after the word is done
		}
	}

}
