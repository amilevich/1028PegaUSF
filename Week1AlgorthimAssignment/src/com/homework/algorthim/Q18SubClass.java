package com.homework.algorthim;

public class Q18SubClass extends Q18Abstract {

	@Override
	public boolean uppercase(String s) {
		for(int i =0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String lowercase(String s) {
			s=s.toUpperCase();
			return s;
	}


	@Override
	public int convertToInt(String i) {
		 
		return Integer.valueOf(i)+10;
	}

	

}
