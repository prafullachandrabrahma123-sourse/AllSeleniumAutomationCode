package NumberRelatedPrograms;

public class A05_ReverseAllNumbersFromAnArray {

	public static void main(String[] args) {
		  
        int[] num = {5,4,3,2,1};
        
        int start = 0;
        
        int reverse = num.length-1;
    
        
        while(start < reverse) {
        	int temp = num[start];
        	num[start] = num[reverse];
        	num[reverse] = temp;
        	
        	start++;
        	reverse--;
        	
        }
        for(int number : num) {
            System.out.println(number);

        }
       
	}

}
