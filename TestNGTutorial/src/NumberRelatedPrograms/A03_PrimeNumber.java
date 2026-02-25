package NumberRelatedPrograms;

import java.util.Scanner;

public class A03_PrimeNumber {
	
	// divisible by 1 and it self

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		 System.out.println("Please Enter a number: ");
		 int num = sc.nextInt();
		 
		   if(isPrime(num)) {
			   System.out.println("Entered number is Prime");
		   }else {
			   System.out.println("Entered number is Not Prime");
		   }
		 
	
	}
	 public static boolean isPrime(int num) {
		 if(num==1 || num==0) {
			 return false;
		 }
		 if(num==2) {
			 return true;
		 }
		 for(int i=2; i<=num/2; i++) {
			 if(num%i==0) {
				 return false;
			 }
		 }
		 return true;
	 }
}


