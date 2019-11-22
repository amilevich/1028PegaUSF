package problem8;

import java.util.ArrayList;

public class Solution8 {
	
	static ArrayList<String> palindrome = new ArrayList<>();
	static ArrayList<String> non_palindrome = new ArrayList<>();
	static String[] stringsList = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
	
	public static void main(String[] args) {
		sorter(stringsList);
		System.out.println("palindrome list: "+ palindrome);
		System.out.println("none-palindrome list: "+ non_palindrome);

	}

	public static void sorter(String[] stringList) {
		for (int i=0; i<stringsList.length; i++) {
			String str = stringsList[i];
			StringBuffer sbuff = new StringBuffer(str).reverse();
			String revStr = sbuff.toString(); 
			if(revStr.equals(str)) {
				palindrome.add(str);
			}else {
				non_palindrome.add(str);
			}
		}
	}
	

}
