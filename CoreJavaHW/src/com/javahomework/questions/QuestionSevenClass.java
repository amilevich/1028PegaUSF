package com.javahomework.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuestionSevenClass {
	/*
	 * Sort two employees based on their name, department, 
	 * and age using the Comparator interface
	 * */
	
	public static void main (String[] args) {
		ArrayList<Employee> emparr = new ArrayList<>();
		emparr.add(new Employee("Anthony","Sales",25));
		emparr.add(new Employee("Adalberto","Technical Support",21));
		
		System.out.println("The wo employees not sorted:");
		for(int i = 0; i < emparr.size(); i++) {
			System.out.println(emparr.get(i));
		}
		System.out.println("-------------------------------------");
		System.out.println("The two employes sorted by name:");
		Collections.sort(emparr, new SortByName());
		for(int a = 0; a < emparr.size(); a++) {
			System.out.println(emparr.get(a));
		}
		System.out.println("-------------------------------------");
		System.out.println("The two employees sorted by department:");
		Collections.sort(emparr, new SortByDept());
		for(int b = 0; b < emparr.size(); b++) {
			System.out.println(emparr.get(b));
		}
		System.out.println("-------------------------------------");
		System.out.println("The two employees sorted by age:");
		Collections.sort(emparr, new SortByAge());
		for(int j = 0; j < emparr.size(); j++) {
			System.out.println(emparr.get(j));
		}
	}
}
 class Employee { //<-------------------------------------------------------to make this sort work i created a nested class Employee
	private String name;//<-------------------------------------------------an employee has a name
	private String dept;//<-------------------------------------------------and employee works in a department
	private int age;//<-----------------------------------------------------all employees have an age
	
	//////This is my employe constructor that takes in the arguments of name, department and age
	public Employee(String name, String dept, int age) {
		this.setName(name);
		this.setDept(dept);
		this.setAge(age);
	}
	
	////this is my toString method so i can get a string representation of my employee object
	public String toString() {
		
		return this.getName() + " " + this.getDept() + " " + this.getAge();
	}

	public String getName() {//<--------------------------------------------this is the getter method that gets the name of employee
		return name;
	}

	public void setName(String name) {//<-----------------------------------this is the setter method that sets the name of employee
		this.name = name;
	}

	public String getDept() {//<---------------------------------------------this is the getter method that gets the department
		return dept;
	}

	public void setDept(String dept) {//<------------------------------------this is the setter method that sets the department
		this.dept = dept;
	}

	public int getAge() {//<-------------------------------------------------this is the getter method that gets the age of employee
		return age;
	}

	public void setAge(int age) {//<-----------------------------------------this is the setter method that sets the age of employee
		this.age = age;
	}
}
 //////////////////////////////////Class that implements the comparator interface so we can override the compare method////////////////
class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getName().compareTo(emp2.getName());//<------------------compares the name of both employees
	}
	
}
//////////////////////////////////Class that implements the comparator interface so we can override the compare method////////////////
class SortByDept implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getDept().compareTo(emp2.getDept());//<--------------------compares the departments of both employees
	}
	
}
//////////////////////////////////Class that implements the comparator interface so we can override the compare method////////////
class SortByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getAge() - emp2.getAge(); //<------------------------------compares the two employee's age
	}
}
