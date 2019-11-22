package com.example.reverse;

public class MyClass {
	
	public static void main(String[] args) {
	    
		char aux;
		StringBuffer a = new StringBuffer("zorra");
		System.out.print(a); 
		System.out.print("---");
		
		for(int i = 0; i < a.length() - i -1; i++) {
			aux = a.charAt(i);
			a.setCharAt(i, a.charAt(a.length() - i -1));
			a.setCharAt(a.length() - i -1, aux);		
		}
		System.out.print(a);
		
		
		
		 	
	}
}
