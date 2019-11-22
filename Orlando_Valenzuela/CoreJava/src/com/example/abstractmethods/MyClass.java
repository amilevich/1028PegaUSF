package com.example.abstractmethods;

public class MyClass {
	public static void main(String[] args) {
		
		AbstractMethodsChild m = new AbstractMethodsChild();
		
		System.out.println("contains uppercase: " + m.CheckUpCharacters("proBando"));
		
		System.out.println("convert to  uppercase : " + m.uppercase("probando"));
		
		System.out.println("convert to integer : " + m.stringToInteger("100"));
			
		
	}

}
