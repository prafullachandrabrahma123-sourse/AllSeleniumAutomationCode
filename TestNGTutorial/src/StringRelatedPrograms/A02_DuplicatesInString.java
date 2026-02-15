package StringRelatedPrograms;

import java.util.HashMap;
import java.util.Map;

public class A02_DuplicatesInString {

	public static void main(String[] args) {

		/*
		String str = "automation";
		Map<Character, Integer> map = new HashMap<>();

		for(char c : str.toCharArray()) {
		    map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
		    if(entry.getValue() > 1) {
		        System.out.println(entry.getKey());
		    }
		}
		
		*/
		
		    String str = "automation";
            str.chars()
              .mapToObj(c -> (char) c)
              .filter(ch -> str.indexOf(ch) != str.lastIndexOf(ch))
               .distinct()
                .forEach(System.out::println);

      
                  

	}

}
