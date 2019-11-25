package com.projectzero.validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
	
	private static Scanner input = new Scanner(System.in);
	//////////////////////////////////////THIS IS THE CLASS THAT HANDLES MY VALIDATIONS////////////////////////////////////////////////
	//-------------this method below validates the user name
	public static boolean usernameValidation(String username) {
		String regex = "^[a-z0-9_-]{5,15}$";
		Pattern p = Pattern.compile(regex);
		boolean matcher = p.matcher(username).matches();
		return matcher;
	}
	//-------------this method below retrieves the validated user name
	public static String obtainValidUsername() {
		String username = input.nextLine();
		while(!usernameValidation(username)) {
			username = input.nextLine();
		}
		return username;
	}
	//-------------this method below validates the password
	public static boolean passwordValidation(String password) {
		String regex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})"; 
		Pattern p = Pattern.compile(regex);
		if(password == null) {
			return false;
		}
		return p.matcher(password).matches();
	}
	//-------------this method below retrieves the validated password
	public static String obtainValidPassword() {
		String pass = input.nextLine();
		while(!passwordValidation(pass)) {
			pass = input.nextLine();
		}
		return pass;
	}
}
