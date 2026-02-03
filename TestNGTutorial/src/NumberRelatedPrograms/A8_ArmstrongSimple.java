package NumberRelatedPrograms;

import java.util.Scanner;

public class A8_ArmstrongSimple {

	

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        int original = number;
	        int sum = 0;

	        while (number > 0) {
	            int digit = number % 10;       // Extract last digit
	            sum += Math.pow(digit, 3); // Cube and add (Or you can use sum += digit*digit*digit  [---for 3 digit])
	            number /= 10;                  // Remove digit
	        }

	        if (sum == original) {
	            System.out.println(original + " is an Armstrong number.");
	        } else {
	            System.out.println(original + " is not an Armstrong number.");
	            
	            //There is no 2 digit Armstrong number. It's starts from 3 digits. (like 153 and 4 digit is 1634) 
	        }
	    }
	}
