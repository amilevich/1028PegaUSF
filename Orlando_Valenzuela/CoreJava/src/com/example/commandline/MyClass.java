package com.example.commandline;

public class MyClass {

	public static void main(String[] args) {
		
		if (args.length == 1) {
			System.out.println("The string readed has " + args[0].length() + "characters");
		}
		else {
			System.out.println("Enter a string valid");
		}

	}

}
