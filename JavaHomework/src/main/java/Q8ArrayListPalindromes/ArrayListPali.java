package Q8ArrayListPalindromes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ArrayListPali {
	/*
	 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did” 
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<String> all = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		ArrayList<String> pali = new ArrayList<>();
		
		//output original all list
		ListIterator<String> iterator = all.listIterator();
		System.out.println("The original list of words to check for palindromes:");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		//loop to check each element in the all list
		for(int i=0; i<all.size(); i++) {
			String rev = reverseInput(all.get(i));
			if(rev.contentEquals(all.get(i))) {					//check to see if it is a palindrome
				pali.add(all.get(i));							//if it is: add to pali list
			}
		}
		
		//output the new pali list
		ListIterator<String> iterator2 = pali.listIterator();
		System.out.println("\n\nThe palindromes found in the original list are:");
		while(iterator2.hasNext()) {
			System.out.print(iterator2.next() + " ");
		}

	}
	
	private static String reverseInput (String value) {
		String temp = "";
		for(int i = value.length()-1; i>=0;i--) {
			temp+=value.charAt(i);
		}
		return temp;
	}

}
