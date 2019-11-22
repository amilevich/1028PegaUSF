package com.homework.qseven;

import java.util.ArrayList;
import java.util.Collections;

public class Qseven {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Tom", "Sporting Goods", 23));
		employees.add(new Employee("Jerry", "Bakery", 20));
		
		System.out.println("Unsorted");
		for (int i=0; i<employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		Collections.sort(employees, new Sortbyname());
		
		System.out.println("Sorted by name");
		for (int i=0; i<employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		Collections.sort(employees, new Sortbydepartment());
		
		System.out.println("Sorted by department");
		for (int i=0; i<employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		Collections.sort(employees, new Sortbyage());
		
		System.out.println("Sorted by age");
		for (int i=0; i<employees.size(); i++) {
			System.out.println(employees.get(i));
		}

	}
}
