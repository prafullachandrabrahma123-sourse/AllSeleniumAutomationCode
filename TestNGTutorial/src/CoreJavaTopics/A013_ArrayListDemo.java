package CoreJavaTopics;

import java.util.ArrayList;
import java.util.List;

public class A013_ArrayListDemo {

	public static void main(String[] args) {

		 List<String> a = new ArrayList<String>();
	        
	        a.add("apple");
	        
	        a.add("banana");

	        a.add("cherry");

	        a.add("mango");
	        
	        a.add("apple");
	        
	        a.remove(0);
	        
	        //System.out.println(a);
	        
	        for(int i = 0; i< a.size();i++) {
	        	System.out.println(a.get(i));
	        	System.out.println(i);
	        }

	}

}
