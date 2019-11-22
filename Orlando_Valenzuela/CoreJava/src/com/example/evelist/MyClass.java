package com.example.evelist;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {
		ArrayList<Integer> p = new ArrayList<>();
		
		for(int i = 1; i <= 100; p.add(i++));
		
		p.forEach(n->{if(n%2 == 0) {System.out.println(n);}});

	}

}
