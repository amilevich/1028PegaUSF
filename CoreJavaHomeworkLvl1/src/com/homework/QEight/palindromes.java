package com.homework.QEight;

import java.util.ArrayList;

public class palindromes {
	
	//Lomar Stlouis
	// Pega 1028
	
	

	public static void main(String[] args) {
		
		ArrayList<String> mainList = new ArrayList<String>();
		ArrayList<String> secList = new ArrayList<String>();
		
		String n1 = "karen";
		String n2 = "madam";
		String n3 = "tom";
		String n4 = "civic";
		String n5 = "radar";
		String n6 = "sexes";
		String n7 = "jimmy";
		String n8 = "kayak";
		String n9 = "john";
		String n10 = "refer";
		String n11 = "billy";
		String n12 = "did";
		
		
		
		
		mainList.add(n1);
		mainList.add(n2);
		mainList.add(n3);
		mainList.add(n4);
		mainList.add(n5);
		mainList.add(n6);
		mainList.add(n7);
		mainList.add(n8);
		mainList.add(n10);
		mainList.add(n11);
		mainList.add(n12);
		
		
		System.out.print("First List: " + mainList);
		
		// checking the main list
		for (int j=0; j < mainList.size(); j++) {
			
			// Reserving the main list
			String tempS  = reverse(mainList.get(j));
			String tempOne = mainList.get(j);
			
			// check to see if new list string is equal to original list string
			if(tempOne.equals(tempS)== true) {
				secList.add(tempOne);
			}
			
		}
	
		System.out.println("\n\nSecond List: " + secList);
	}
	
	
	
	public static String reverse(String  word) {
		String temp = "";
		
		for(int i = word.length()-1; i >= 0; i--) {
			temp += word.charAt(i);
		}
		return temp;
	}

}
