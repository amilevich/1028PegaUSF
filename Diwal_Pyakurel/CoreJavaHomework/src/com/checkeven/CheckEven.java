package com.checkeven;

public class CheckEven {

	public static void main(String[] args) {
		checkEven(991);
		checkEven(990);
		checkEven(100);
		checkEven(0);
		checkEven(1);
	
	}
	
	public static void checkEven(Integer num) {
		
		String convertedString = num.toString();
		//Converts to string and Checks the last charAt. If(0,2,4,6,8) then its even
		if(num!=0) {
			if(convertedString.charAt(convertedString.length()-1)=='0'||convertedString.charAt(convertedString.length()-1)=='2'||convertedString.charAt(convertedString.length()-1)=='4'||convertedString.charAt(convertedString.length()-1)=='6'||convertedString.charAt(convertedString.length()-1)=='8') {
				System.out.println("This is even");
			}else {
				System.out.println("This is odd");
			}
		
		}else {
			System.out.println("This is neither even or odd");
		}
		
		
	}

}
