package com.homework.qfive;

public class Qfive {

	public static void main(String[] args) {
		String str = "this is a string";
		int idx = 4;
		System.out.println(sub(str, idx));

	}
	
	public static String sub(String str, int idx) {
		String temp = "";
		for (int i = 0; i < idx; i++) {
			temp += str.charAt(i);
		}
		
		
		return temp;
	}

}
