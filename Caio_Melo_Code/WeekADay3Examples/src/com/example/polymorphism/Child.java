package com.example.polymorphism;

public class Child extends Parent {
	
	//override the talk() method of Parents
	
	@Override
	public void talk() {
		System.out.println("Child is talking");
	}

}
