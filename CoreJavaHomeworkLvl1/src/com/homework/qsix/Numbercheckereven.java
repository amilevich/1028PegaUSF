package com.homework.qsix;

import java.util.Scanner;

public class Numbercheckereven {

	public static void main(String[] args) {
		
		System.out.println("Please enter a number to be checked");
		Scanner scanint = new Scanner(System.in);
		int numCheck = scanint.nextInt();
		//DEvides the number by two and *2 to check if it is even
		if((numCheck/2)*2 == numCheck){
			System.out.println("The number is even");
		}
			
		else {
			System.out.println("The number is odd");
		}
	
		scanint.close();
	}

	
}