package NumberRelatedPrograms;

public class A05_ReverseAllNumbersFromAnArray {

	public static void main(String[] args) {
		
		
		/*
		 
		  Simple Way-
		 
		 int[] numb = {1,2,3,4,5,6};

		   for(int i = numb.length-1; i>=0; i--){
		     
		 System.out.println(numb[i]);  
		   }
		   
		 */
		  
        int[] num = {6,5,4,3,2,1};
        
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
