package com.example.polymorphism;

public class GrandChild extends Child {

	@Override
	public void talk() {
		System.out.println("Grandchild is talking");
	}
	
	public void jump() {
		System.out.println("Grandchild is jumping");
	}
}
