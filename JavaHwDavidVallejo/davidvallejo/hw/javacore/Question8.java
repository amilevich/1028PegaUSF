package davidvallejo.hw.javacore;

import java.util.ArrayList;

/*
 * 
 * Question 8: Write a program that stores the following strings in an ArrayList and saves all
 * the palindromes in another ArrayList.
 * 
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”,
 * “billy”, “did”
 */
public class Question8 {
	public static ArrayList<String> other = new ArrayList<String>();
	//stores the words that are not palindromes 
	public static ArrayList<String> palindrome = new ArrayList<String>();
   //stores the palindromes
	

	public static void main(String[] args) {

		String str[] = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
				"did" };//words being checked for being palindromes
		palindromeWordListParse(str);
		System.out.println(other);
		System.out.println(palindrome);

	}

	public static void palindromeWordListParse(String[] check) {

		for (int i = 0; i < check.length; i++) {
			if (isPalindrome(check[i])) {
				palindrome.add(check[i]);
			} else {
				other.add(check[i]);
			}
		}
	}

	public static boolean isPalindrome(String str2) {
		boolean chk = true;
		for (int i = 0; i < (str2.length() / 2); i++) {
			if ((str2.charAt(i)) == str2.charAt((str2.length()) - 1 - i)) {
				chk = true;
			} else {
				chk = false;
				break;
			}
		}
		return chk;//checking for palindromes
	}
}
