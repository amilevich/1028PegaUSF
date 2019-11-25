package com.Q18;

import java.util.Scanner;

public class ChildClass extends Q18 {

		@Override
		boolean checkUpper(String k) {
			for (int i=0; i<k.length();i++){
				if (Character.isUpperCase(k.charAt(i))) {
					return true;
				}
			}
			return false;
		}

		@Override
		String convertToUpper(String s) {
			String result = s.toUpperCase();
			return result;
		}

		@Override
		void convertTen(String s) {
			int i = 10;
			Integer result = Integer.valueOf(s);
			System.out.print("The converted string plus ten is: ");
			System.out.println(i+result);
			
		}

	
	
	
	public static void main(String[] args) throws Exception{
		
		
				// Creating ChildClass object 
				ChildClass obj = new ChildClass();
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter a string to work with:");
				String input = sc.nextLine();
				
				if(obj.checkUpper(input)) {
					System.out.println("Uppercase values exist.");
				}else {
					System.out.println("Uppercase values don't exist.");
				}
				
				String allUpper = obj.convertToUpper(input);
				System.out.println("The original string is: "+ input);
				System.out.println("The string with each character converted to uppercase is: "+allUpper);
				
				obj.convertTen(input);
		
	}

}
