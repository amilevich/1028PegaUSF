package com.example.llama;

public class MainDriver {

	public static void main(String[] args) {
		
		Lllama jerry = new Lllama();
		jerry.setName("Jerry");
		jerry.setHeight(8);
		jerry.setWeight(20023);
		
		System.out.println("The Llama's name is " + jerry.getName());
		System.out.println(jerry.getName() + "'s Height is " + jerry.getHeight());
		System.out.println(jerry.getName() + "'s Weight is " + jerry.getWeight());
		
		
		Lllama frank = new Lllama();
		frank.setName("Frank");
		frank.setHeight(57);
		frank.setWeight(8);
		
		System.out.println("The Llama's name is " + frank.getName());
		System.out.println(frank.getName() + "'s Height is " + frank.getHeight());
		System.out.println(frank.getName() + "'s Weight is " + frank.getWeight());
		
		Animal tim = new Lllama();
		
		
	}
}
