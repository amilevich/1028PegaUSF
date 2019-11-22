package com.example.abstractmethods;

public class AbstractMethodsChild extends AbstractMethods {

	@Override
	public boolean CheckUpCharacters(String s) {
		
		return s.matches("[a-z]*[a-zA-Z]+[a-z]*");
	}

	@Override
	public String uppercase(String s) {
		
		return s.toUpperCase();
	}

	@Override
	public Integer stringToInteger(String s) {
		
		return Integer.parseInt(s) + 10;
	}

}
