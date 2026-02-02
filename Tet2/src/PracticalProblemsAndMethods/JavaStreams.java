package PracticalProblemsAndMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;



public class JavaStreams {
		
		//@Test
		public void manualJava()
		{
		
		ArrayList<String> li = new ArrayList<String>();
		li.add("Rahul");
		li.add("Rama");
		li.add("Ram");
		li.add("Pappu");
		
		int count =0;
		
		for(int i = 0; i<li.size();i++) {
			
			String s = li.get(i);
			
		        if(s.startsWith("R")) {
		        	count++;
		        }
		        
		}
		 System.out.println(count);
		
		

	}
		
		//@Test
		public void streams() {
			
			ArrayList<String> li = new ArrayList<String>();
			li.add("Rahul");
			li.add("Rama");
			li.add("Ram");
			li.add("Pappu");
			
			li.stream().filter(s->s.startsWith("R")).filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
			//System.out.println(s);
		}
		
		//@Test
		public void streamMap() {
			
			ArrayList<String> li = new ArrayList<String>();
			li.add("Rahul");
			li.add("Rama");
			li.add("Ram");
			li.add("Pappu");
			li.add("Baba");
			
			//printing the list with upper case which ends with "a"
			
			li.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			//print the lists as shorting order with last letter "a"
			li.stream().filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			//merge 2 lists
			 List<String>  li2 = Arrays.asList("Baba","Dog","cow");
			 
			 Stream.concat(li.stream(), li2.stream()).forEach(s->System.out.println(s));
			 
			 //any match is present
			 Stream<String> all = Stream.concat(li.stream(), li2.stream());
			  boolean flag = all.anyMatch(s->s.equalsIgnoreCase("Dog"));
			  System.out.println(flag);
			  Assert.assertTrue(flag);
			
			
		}
		
		@Test
		public void streamCollect() {
			
			ArrayList<String> li = new ArrayList<String>();
			li.add("Rahul");
			li.add("Rama");
			li.add("Ram");
			li.add("Pappu");
			li.add("Baba");
			
			Stream<String> al =li.stream().filter(s->s.endsWith("a")).sorted();
			List<String>all = al.collect(Collectors.toList());
			System.out.println(all.get(1));
			
			Integer[] in = {1,2,3,4,4,2,3,5,6};
			
			List<Integer> alin =Arrays.asList(in);
			
			alin.stream().sorted().distinct().forEach(s->System.out.println(s));
			List<Integer> allv = alin.stream().distinct().collect(Collectors.toList());
			System.out.println( allv.get(2));
			
		}

}
