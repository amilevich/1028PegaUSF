package com.homework.QSeven;

import java.util.Comparator;

public class compartorClass implements Comparator {
	
	static class Employee {
		String name;
		String department;
		int age;
		
			public Employee(String name, String department, int age){
			 this.name = name;
			 this.department = department;
			 this.age = age;
				
			}
			
			public int compare(Object o1, Object o2) {
				
				return 0;
			}
			
	}

	public static void main(String[] args) {
		

	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
