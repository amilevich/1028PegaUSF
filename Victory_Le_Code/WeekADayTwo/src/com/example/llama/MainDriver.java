package com.example.llama;

public class MainDriver {

		public static void main (String[] args) {
			
			llama Jerry = new llama();
			Jerry.setName("Jerry");
			Jerry.setHeight(32);
			Jerry.setWeight(1000);
			
			System.out.println("The llama's name is " + Jerry.getName());
			System.out.println(Jerry.getName() + "'s height is " + Jerry.getHeight());
			
			llama Frank = new llama();
			Frank.setName("Frank");
			Frank.setHeight(57);
			
			System.out.println("The llama's name is " + Frank.getName());
			System.out.println(Jerry.getName() + "'s height is " + Frank.getHeight());
		}
}
