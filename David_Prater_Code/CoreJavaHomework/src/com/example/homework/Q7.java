package com.example.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q7 {
	
	// Hello and welcome to the madness
	// There are five classes in here 
	

	public void sortEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Jonny", "Welder", 30));
		employees.add(new Employee("David", "Software", 26));

		// Sort by name
		Collections.sort(employees, new NameComparator());
		System.out.println("Sorted by name: " + employees.toString());
		// Sort by age
		Collections.sort(employees, new AgeComparator());
		System.out.println("Sorted by age: " + employees.toString());
		// Sort by department
		Collections.sort(employees, new DepartmentComparator());
		System.out.println("Sorted by department: " + employees.toString());
	}

}

// Create an encapsulated Employee class with vars, constructors, getters and setters and toString
 class Employee {

	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	
}

 
 // This class sorts employees by name (a -> z)
class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		} else if (o1.getName().compareTo(o2.getName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}

// This class sorts youngest to oldest
class AgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {

	        return o1.getAge() - o2.getAge(); 
	}
	
}


// This class sorts employees by name (a -> z)
class DepartmentComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getDepartment().compareTo(o2.getDepartment()) > 0) {
			return 1;
		} else if (o1.getDepartment().compareTo(o2.getDepartment()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
