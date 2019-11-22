package com.homework.qeighteen;

import java.util.Scanner;

public class Qeighteen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String upperCheck;
		String intConvert;
		String upperConvert;
		AbstractOverride q18 = new AbstractOverride();
		
		System.out.print("Please input a word to check for uppercase: ");
		upperCheck = sc.nextLine();
		System.out.print("Please input a word to convert to uppercase: ");
		upperConvert = sc.nextLine();
		System.out.print("Please input a number you want 10 added to it: ");
		intConvert = sc.nextLine();
		
		System.out.println(q18.checkForCaps(upperCheck));
		System.out.println(q18.convertToUpper(upperConvert));
		System.out.println(q18.convertToInt(intConvert));
		
		
		

	}

}
