package com.example.palindromes;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {
		
		ArrayList<String> p = new ArrayList<>();
		
		p.add("karan");
		p.add("madam");
		p.add("tom");
		p.add("civic");
		p.add("radar");
		p.add("sexes");
		p.add("jimmy");
		p.add("kayak");
		p.add("john");
		p.add("refer");
		p.add("billy");
		p.add("billy");
		
		p.forEach(n->{ if(palindro(n))System.out.println(n);});
			
	}
	private static boolean palindro(String s) {
		
		for(int i = 0; i < s.length(); i++)
			if (s.charAt(i) != s.charAt(s.length()-i-1))
			   return false;
		return true;
	}

}
