package com.homework.algorthim;

public class Q6Even {

	public void even(double num) {
		 double n = num/2;
		 double roundUp = Math.floor(n)*2;
		 System.out.println(roundUp);
		 
		 if(num == roundUp) {
			 System.out.println("Even");
		 }else {
			 System.out.println("Odd");
		 }
		 
		
	}
}
