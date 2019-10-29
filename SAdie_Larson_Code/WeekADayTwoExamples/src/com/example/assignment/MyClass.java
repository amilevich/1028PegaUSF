package com.example.assignment;

public class MyClass {
public static void main(String[] args) {
	States ca = new States();
	States mn = new States();
	States fl = new States();
	
	
	ca.setName("California");
	ca.setPopulation(1_230_000);
	ca.setPercentStudents(0.45);
	
	
	fl.setName("Florida");
	fl.setPopulation(1_130_120);
	fl.setPercentStudents(0.34);
	
	mn.setName("Minnesota");
	mn.setPopulation(1_030_080);
	mn.setPercentStudents(0.64);
	
	
	States.hello();
	
	System.out.println(ca.getName());
	ca.peopleInterested(10, 20, 30, 40);
	
	
	System.out.println(fl.getName());
	fl.peopleInterested(100, 30, 12);
	
	System.out.println(mn.getName());
	mn.peopleInterested(80, 60, 46,30,20,12,41,10);
	
	String statesList[] = {ca.getName(), fl.getName(), mn.getName()};
	for(int i = 0; i < statesList.length; i++) {
		System.out.println(statesList[i]);
		
	}
	
	
	System.out.println(ca);
	
}
}
