package com.example.javacore;

import com.example.javacore.elevemA.QuestionElevenB;

/*Write a program that would access two float-variables from
 *  a class that exists in another package. Note, you will need to 
 *  create two packages to demonstrate the solution.
 * 
 */
public class QuestionEleven extends QuestionElevenB {

	public static void main(String[] args) {
		
		QuestionElevenB cab = new QuestionElevenB();
		
		float c = cab.a;
		float d = cab.b;
		
		System.out.println(c);
		System.out.println(d);
		
	}

}
