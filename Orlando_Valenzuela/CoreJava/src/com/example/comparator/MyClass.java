package com.example.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyClass {

	public static void main(String[] args) {
		
		List<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee("Fransisco", "a", 26));
		emp.add(new Employee("Fransisco", "b", 15));
		emp.add(new Employee("Camilo", "z", 33));
		emp.add(new Employee("Camilo", "z", 27));
		emp.add(new Employee("Juana", "e", 40));
		

		emp.forEach(n->System.out.println(n));
		System.out.println("---------------------------------------");
		Collections.sort(emp,new CompEmployee());
		emp.forEach(n->System.out.println(n));

	}

}

class Employee{
	String name;
	String demartment;
	int age;
	
	Employee(String n, String d, int a){
		
		this.name = n;
		this.demartment = d;
		this.age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDemartment() {
		return demartment;
	}


	public void setDemartment(String demartment) {
		this.demartment = demartment;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee " + name + ",  " + demartment + ",  " + age;
	}
	
}

class CompEmployee implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		int n = e1.getName().compareTo(e2.getName()), d;
		
		if (n == 0) {
			 d = e1.getDemartment().compareTo(e2.getDemartment());
			 
			 if (d == 0) {
				 
				return ((e1.getAge()-e2.getAge()) == 0 )?n:(e1.getAge()-e2.getAge())/Math.abs(e1.getAge()-e2.getAge());  
			 }
			 else
				 return d;
		}
		else
			return n;	
	}
	
}
