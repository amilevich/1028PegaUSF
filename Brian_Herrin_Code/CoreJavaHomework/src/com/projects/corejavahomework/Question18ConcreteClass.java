package com.projects.corejavahomework;

public class Question18ConcreteClass extends Question18SuperClass {

	@Override
	boolean isUpperCaseCharactersInString(String input) {
		char[] temp = input.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			if(Character.isLetter(temp[i])) {
				if(Character.isUpperCase(temp[i])) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	String morphUpperCaseCharacterString(String input) {
		if(!isUpperCaseCharactersInString(input)) {
			return input;
		}
		char[] temp = input.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			if(Character.isLetter(temp[i])) {
				if(Character.isLowerCase(temp[i])) {
					Character.toUpperCase(temp[i]);
				}
			}
		}
		return String.valueOf(temp);
	}

	@Override
	String morphIntegerPlusTen(String input) {
		int temp;
		try {
			temp = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			temp = 0;
		}
		temp = temp + 10;
		return String.valueOf(temp);
	}
}
