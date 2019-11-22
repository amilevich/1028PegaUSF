package com.example.substring;

public class MyClass {

	public static void main(String[] args) {
		
      System.out.println(substring("Murcielago", 3));
		
	}
	
	private static String substring(String s, int l) {
		
		StringBuffer sa = new StringBuffer();
		l = (l > s.length())? s.length():l;
		for(int i = 0; i < l; sa.append(s.charAt(i)), i++);
		return sa.toString();
		
	}

}
