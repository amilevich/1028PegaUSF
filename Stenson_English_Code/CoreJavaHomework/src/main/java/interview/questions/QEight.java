package interview.questions;

import java.util.ArrayList;

public class QEight {

//	 “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
	
	public static void main(String[] args) {
		ispalindrome();
	}
	
	public static void ispalindrome() {
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		ArrayList<String> nonPalindromes = new ArrayList<String>();
		
		stringList.add("karan");
		stringList.add("madam");
		stringList.add("tom");
		stringList.add("civic");
		stringList.add("radar");
		stringList.add("sexes");
		stringList.add("jimmy");
		stringList.add("kayak");
		stringList.add("jon");
		stringList.add("refer");
		stringList.add("billy");
		stringList.add("did");
		

		
		for(String s : stringList) {
			String x = palindrome(s);
			if(x.equals(s)) {
				palindromes.add(s);
			}else {
				nonPalindromes.add(s);
			}
		}
		
		
		
		System.out.println(palindromes.toString());
		System.out.println(nonPalindromes.toString());
	}
	
	// 
	public static String palindrome(String s) {
		String y = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			y+= s.charAt(i);
		}
		return y;
	}

}