package com.example.assignmentOne;

import java.util.Random;

public class MainDriver {

	
	static Random r = new Random(); 
	static boolean greenLight = r.nextBoolean();
	
	public static void main(String[] args) {
		
	
		Model m = new Model();	
		Model m2 = new Model();	
		Model m3= new Model();	
		
		m.setName("Tesla");
		m.getName();
		
		
		if (greenLight == true) {
			m.runItBackTurbo();
		} else {
			m.useBreak();
		}
	
		
		Model.eat();
		m.year();
		
		
	}
}
