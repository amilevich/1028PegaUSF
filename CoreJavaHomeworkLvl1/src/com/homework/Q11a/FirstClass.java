package com.homework.Q11a;

//need to view other class in different package
import com.homework.Q11b.SecondClass;

// reading from a class in another package
public class FirstClass extends SecondClass {

	public static void main(String[] args) {
		
		// calls other class
		SecondClass pull = new SecondClass();
		
		System.out.println("Numbers from another package: ");
		System.out.println("Number 1 " + pull.A  + " Number 2: " + pull.B);
		
		

	}

}
