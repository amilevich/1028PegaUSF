package com.homework.QThirteen;

import java.util.Scanner;

public class TriangleForm {

	public static void main(String[] args) {
		int valueZero = 0;
		int valueOne = 1;
		int temp = 0;
	
	Scanner scanint = new Scanner(System.in);
		
	System.out.println("Please enter a value your want the size of the triangle: ");
	int value = scanint.nextInt();
		
 	for(int i = 0; i < value; i++) {
			for(int j = 0; j <= i; j++) {
				
				
				if (temp == 0) {
					System.out.print(valueZero + " ");
					temp = valueOne;
				}
				
				else if(temp == 1) {
					System.out.print(valueOne + " ");
					temp = valueZero;
				}
		 
				
		 	}
			System.out.println("\n");
		}

	}

}
