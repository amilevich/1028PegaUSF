package com.ternary;

public class Ternary {

	public static void main(String[] args) {
		
		int min = getMin(1,2);
		System.out.println(min); 
		
	}
	
	public static int getMin(int x, int y) {
		int max = x>y?x:y;
		//condition will be converted to boolean and depending on that first or recond will e executed
		return max;
	}
	
}