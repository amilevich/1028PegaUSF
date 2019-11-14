package com.assignment1;

public class Q18 extends Q18abstractClass{

	@Override
	public boolean checkCaps(String string) {
		if(string == string.toLowerCase()) {
			return false;
		}
		return true;
	}

	@Override
	public String convertUpperCase(String string) {
		return string.toUpperCase();
	}

	@Override
	public int toInteger(String string) {
		return Integer.parseInt(string);
	}
	
	
	
	

}
