package NumberRelatedPrograms;

import java.util.HashMap;
import java.util.Map;

public class A11_RepeatedNumbersAndHowManyRepeatedFromAnArray {

	public static void main(String[] args) {

		int[] num = {1,2,2,2,2,2,4,5,6,4,3,2};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int numb : num) {
        	map.put(numb, map.getOrDefault(numb, 0)+1);
        }
        System.out.println(map);
        //System.out.println();

        
        // Print numbers that appear only once
        System.out.println("Non Repeated Values are:");

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {

                System.out.println(entry.getKey());
            }
        }
	}

}
