package com.assignment1;

import java.util.Comparator;

public class Q7 {
	
	static class AgeComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getAge() == o2.getAge()) {
				return 0;}
			else if(o1.getAge() < o2.getAge()) {
				return 1;
			}
			else {
				return -1;
			}
		}
}
	
	static class NameComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	static class DepartmentComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
		
	}
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Bob","Banking", 22);
		Employee e2 = new Employee("Aisha","Finance",24);
		
		AgeComparator apple = new AgeComparator();
		System.out.println(apple.compare(e1, e2));
		NameComparator banana = new NameComparator();
		System.out.println(banana.compare(e1, e2));
		DepartmentComparator kiwi = new DepartmentComparator();
		System.out.println(kiwi.compare(e2, e1));
		
	}


}
