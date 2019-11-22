package com.fibonacci;

import java.util.ArrayList;

public class FiboacciSequence {
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> lists = new ArrayList<>();
		lists.add(0);
		lists.add(1);
		//Passing arguments on the method
		createFibboacci(lists, 25);
		//printing the list
		System.out.println(lists);
		
		
	}
	
	//This method will take 2 parameters
	//The first parameter will take the Array list where first two numbers are added
	//The second parameter will be the number of Fibbonacci sequence you want to create
	public static void createFibboacci(ArrayList<Integer> lists, int numberOfFibbonaci) {
		//For loop to iterate through the last 2 elements and will add the numbers to make the number third
		for(int i = 0; i<numberOfFibbonaci-2; i++) {
			lists.add(lists.get(i)+lists.get(i+1));
		}
	}
	
	
	

}
