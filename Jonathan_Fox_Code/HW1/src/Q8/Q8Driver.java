package Q8;

import java.util.ArrayList;

public class Q8Driver {

	//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did” 
	public static void main(String[] args) {
		ArrayList<String> sa = new ArrayList<String>();
		ArrayList<String> pa = new ArrayList<String>();
		
		sa.add("karan");
		sa.add("madam");
		sa.add("tom");
		sa.add("civic");
		sa.add("radar");
		sa.add("sexes");
		sa.add("jimmy");
		sa.add("kavak");
		sa.add("john");
		sa.add("refer");
		sa.add("billy");
		sa.add("did");
		
		//print full list and add palindromes to pa
		System.out.printf("Full list: ");
		for(String s : sa) {
			if(isPalindrome(s)) pa.add(s);
			System.out.printf("%s ", s);
		}
		System.out.printf("\n\n");
		
		
		//print palindromes
		System.out.printf("Palindromes: ");
		for(String s: pa) System.out.printf("%s ", s);
		System.out.printf("\n");
	}
	
	public static boolean isPalindrome(String s) {
		String s2 = "";
		
		//make s2 the reverse of s
		for (int i=0; i<s.length(); i++) s2 += String.format("%c", s.charAt(s.length()-1-i));
		
		if(s.equals(s2)) return true;
		return false;
	}

}
