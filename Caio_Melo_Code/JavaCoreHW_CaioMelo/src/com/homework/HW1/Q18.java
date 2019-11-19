package com.homework.HW1;

public class Q18 extends Q18_Aux {

	//1st
	public Boolean checkUppercase(String x) { //Converts new string to lowercase, compares original string to see if its the same.
			
			String y = x.toLowerCase();
			if(y.contentEquals(x)) {
				return false;
				
			}
			else {
					return true;
				}
	}
	
	//2nd
	public String convertLower(String x) { //Convert to lower case
		
		String y = x.toUpperCase();
		return y;
		
	}
	//3rd
	public Integer convertStr(String x) {
		int toInt = Integer.parseInt(x); //Get integer value of passed string using ParseInt, returns int.
		toInt +=10;
		return toInt;

	}



	public static void main(String[] args) {

		Q18 obj = new Q18();
		
		String test = "StRinG";
		String number = "10";
		
		System.out.println("1st "+ obj.checkUppercase(test));
		System.out.println("2nd "+obj.convertLower(test));
		System.out.println("3rd "+obj.convertStr(number));

		
		
	}

}
