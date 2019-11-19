package com.homework.HW1;
/*
 * Q11 Access two float variables from a class that exists in another package (com.homework.Q11_Aux)
 */
import com.homework.HW1_Aux.*;

public class Q11 {

	public static void main(String[] args) {
		
		Q11_Aux test = new Q11_Aux(); //Creating new object from imported class.
		System.out.println("First value from com.homework.aux: " + test.export);
		System.out.println("Second value from com.homework.Q11_aux:" + test.export1);
	
	}
}
