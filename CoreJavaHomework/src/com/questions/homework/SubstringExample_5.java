package com.questions.homework;

import java.util.Scanner;

public class SubstringExample_5 {
	
	public static void main(String[] args) {
		myStringMethod();
	}
	
	public static void myStringMethod() {
		
		String str = new String ("Test this sentence for method.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Test this sentence for the method.");
		int idx = sc.nextInt();
		sc.nextLine();
		
		int x = str.length()-idx;// get rid of these chars at positions
		String temp = "";
		
		for(int i = 0; i < idx; i++) {
			temp = temp + str.charAt(i);// show only these chars
		}
		
		System.out.println(temp);
	}

}
