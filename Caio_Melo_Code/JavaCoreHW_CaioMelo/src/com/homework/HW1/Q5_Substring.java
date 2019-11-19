package com.homework.HW1;

//Q5 - Method to return substring of passed string from 0 to the index passed, inclusive. 

public class Q5_Substring {
	public static void main(String[] args) {
		
		String str = "123456789";  //input string
		String substr = substring(str,5); //assigning substring method to new string
		
		System.out.println(substr);
		
	}
	
	public static String substring(String x, int idx) {
		
		String[] y = x.split(""); //split string characters into array using "" as regex 
		String z = "";
		
		for(int i = 0;i<idx;i++) {
			
			z += y[i]; //Add the character in the array at index i to the string to be returned
			
		}
		return z;
	}

}
