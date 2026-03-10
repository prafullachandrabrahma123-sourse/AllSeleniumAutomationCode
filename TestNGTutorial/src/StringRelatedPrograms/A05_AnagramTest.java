package StringRelatedPrograms;

import java.util.Arrays;
import java.util.List;

public class A05_AnagramTest {

	public static void main(String[] args) {

		        String str1 = "Listen";
		        String str2 = "Silent";

		        if (isAnagram(str1, str2)) {
		            System.out.println(str1 + " and " + str2 + " are anagrams!");
		        } else {
		            System.out.println(str1 + " and " + str2 + " are not anagrams.");
		        }
		    }

		    public static boolean isAnagram(String s1, String s2) {
		        // Remove whitespace and convert to lowercase for a fair comparison
		        s1 = s1.replaceAll("\\s", "").toLowerCase();
		        s2 = s2.replaceAll("\\s", "").toLowerCase();

		        // If lengths differ, they can't be anagrams
		        if (s1.length() != s2.length()) {
		            return false;
		        }

		        // Convert to char arrays and sort them
		        char[] charArray1 = s1.toCharArray();
		        char[] charArray2 = s2.toCharArray();
		        
		        Arrays.sort(charArray1);
		        Arrays.sort(charArray2);

		        // Compare the sorted arrays
		        return Arrays.equals(charArray1, charArray2);
		    }

	}

