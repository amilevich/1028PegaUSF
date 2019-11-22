package com.examples.corehomework;

public class Q18MainDriver  extends Q18AbstractClass{

	@Override
	public boolean isUpperCase(String s) {
		if(!s.equals(s.toLowerCase())) {
			return  true;
		}else {
			return false;
		}
		
	}

	@Override
	public String converLowerCaseToUpperCase(String s) {
		return s;
	}

	@Override
	public void converStringToInteger(String s, int i, int j) {
		int a = Integer.parseInt(s);
		int b = 10;
		System.out.println(a + " + " + b + " = " + (a+b));
	}
	
	public static void main(String[]args) {
		String s = "hello world";
		String s1 ="10";
		Q18MainDriver qb = new Q18MainDriver();
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