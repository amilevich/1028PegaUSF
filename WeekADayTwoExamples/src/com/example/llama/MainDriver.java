package com.example.llama;

public class MainDriver {
	
	public static void main(String[]args) {
		
		Llama Jerry = new Llama();
		Jerry.setName("Jerry");
		Jerry.setHeight(32);
		System.out.println("The llama's name is " + Jerry.getName());
		System.out.println(Jerry.getName() + "'s height is " + Jerry.getHeight());
		
		
		
		Llama Frank = new Llama();
		Frank.setName("Frank");
		Frank.setHeight(57);
		System.out.println("The llama's name is " + Frank.getName());
		System.out.println(Jerry.getName() + "'s height is " + Frank.getHeight());

	}
	
	

}
