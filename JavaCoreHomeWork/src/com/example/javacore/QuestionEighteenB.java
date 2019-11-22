package com.example.javacore;

public class QuestionEighteenB  extends QuestionEitghteen{

	@Override
	public boolean isUpperCase(String s) {
		//Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
		if(!s.equals(s.toLowerCase())) {
			return  true;
		}else {
			return false;
		}
		
	}

	@Override
	public String converLowerCaseToUpperCase(String s) {
	//Convert all of the lower case characters to uppercase in the input string, and return the result.
		
		return s;
	}

	@Override
	public void converStringToInteger(String s, int i, int j) {
//Convert the input string to integer and add 10, output the result to the console.
		int a = Integer.parseInt(s);
		int b = 10;
		System.out.println(a + " + " + b + " = " + (a+b));
	}
	
	
	
	public static void main(String[]args) {
		String s = "hello world";
		String s1 =" 5";
		QuestionEighteenB qb = new QuestionEighteenB();
		System.out.println("");
		System.out.println(qb.isUpperCase(s));
		System.out.println("*************************************************");
		System.out.println(qb.converLowerCaseToUpperCase(s));
		System.out.println("*convert from lowercase to uppercase");
		System.out.println(s.toUpperCase());
		System.out.println("----------------------------------------------------");
        System.out.println("******************************************************");
        System.out.println(s1);
	}

}
