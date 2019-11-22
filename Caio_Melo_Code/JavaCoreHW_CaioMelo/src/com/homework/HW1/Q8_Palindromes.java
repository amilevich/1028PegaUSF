package com.homework.HW1;

import java.util.ArrayList;


//Q8 - Takes in ArrayList of strings,
//and exports an ArrayList with two ArrayList, 
//one thats full of palindromes, and one that is non-palindromes

public class Q8_Palindromes {

	public static void main(String[] args) {
	
	
	ArrayList<String> words = new ArrayList<String>(); //Populate original words

			words.add("Karen");
			words.add("madam");
			words.add("tom");
			words.add("civic");
			words.add("radar");
			words.add("sexes");
			words.add("jimmy");
			words.add("kayak");
			words.add("john");
			words.add("refer");
			words.add("billy");
			words.add("did");
			

	ArrayList<ArrayList<String>> import1 = palList(words); //Arraylist of type Arraylist will be home to the exported ArrayList when PalList is called
	
	
	System.out.println( "Printing Palindrome list..."+ import1.get(0)); //Get index 0 of the export(palindromes)
	System.out.println("Printing non-Palindrome list..." + import1.get(1));//Get index 1 of the import(non palindromes)
	

	
	}
	
	public static boolean isPal(String x) { //Method to return true if its a palindrome
		String y = "";
		
		for(int i = x.length()-1;i>=0;i--) {
			
			y +=x.charAt(i);
			
		}
		if (y.equals(x)) {
			return true;
		}
		return false;
	}
	
	public static ArrayList<ArrayList<String>> palList(ArrayList<String> x){
	
		ArrayList<ArrayList<String>> export = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> palindrome = new ArrayList<String>();
		ArrayList<String> notPalindrome = new ArrayList<String>();
		
		for(String pal: x) { //if is pal or not, add to its seperate ArrayList.
			if(isPal(pal)) {
				palindrome.add(pal);
			}
			else {
				notPalindrome.add(pal);
			}
		}
		
		export.add(palindrome); //Add seperate lists to the ArrayList<ArrayList<String>> Oject.
		export.add(notPalindrome);
		
		
		return export;
		
	}
}

