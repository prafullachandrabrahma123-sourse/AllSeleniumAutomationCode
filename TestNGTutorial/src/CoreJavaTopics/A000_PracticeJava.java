package CoreJavaTopics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A000_PracticeJava {

	public static void main(String[] args) {
		
		
		String name = "madamisamadam";
		
		name.chars()
		.mapToObj(c-> (char)(c)).filter(ch-> name.indexOf(ch) != name.lastIndexOf(ch))
		.forEach(System.out::print);
		


	}

}
