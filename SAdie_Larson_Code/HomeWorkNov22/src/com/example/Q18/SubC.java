package com.example.Q18;

public class SubC extends SuperC {

	@Override
	public boolean upperCase(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUpper(String str) {
		str = str.toUpperCase();
		// for (int i = 0; i < str.length(); i++) {
		// if (!Character.isUpperCase(str.charAt(i))) {
		// str.charAt(i) = Character.toUpperCase(str.charAt(i));
		// }
		// }
		return str;
	}

	@Override
	public int convertToInt(String str) {
		int temp = Integer.valueOf(str);
		return temp + 10;
	}

}
