package CoreJavaTopics;

import java.util.Scanner;

public class PracticeJavaPrograms {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a number: ");
		int num = sc.nextInt();
		int original = num;
	
		int reversed =0;
		
		while(num > 0) {
			int digit = num%10;
			reversed = reversed*10+digit;
			num = num/10;
		}
		if(original == reversed) {
		System.out.println("Original number is Palindrome: " + original);
		}else {
			System.out.println("Original number is not a Palindrome: " + original);
		}

	}

}
