package com.example.core;
//DONE
/*
 * Write a program that would access two float-variables
 *  from a class that exists in another package.
 *  Note, you will need to create two packages to demonstrate the solution.
 */
import com.example.b.FloatVar;

public class Q11 extends FloatVar {

	public static void main(String[] args) {

		System.out.println("Float a is: " + a);
		System.out.println("Float b is: " + b);
	}

}
