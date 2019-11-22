package com.questions.homework;

import java.util.Comparator;

public class ComparatorExample_7 {
	
	public static void main(String[] args) {
		
	}

	static class Comp implements Comparator<Employee>{// Comparator for each attribute

		@Override
		public int compare(Employee e1, Employee e2) {
			if(e1.getAge() == e2.getAge()) {
				return 0;}
			else{
				return 1;
			}
		}

		static class nameComp implements Comparator<Employee>{

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		}

		static class ageComp implements Comparator<Employee>{

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getAge() - e2.getAge();
			}
		}

		static class deptComp implements Comparator<Employee>{

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getDepartment().compareTo(e2.getDepartment());
			}
		}

		public static void main(String[] args) {
			Employee e1 = new Employee("Curtis", 24, "Art");
			Employee e2 = new Employee("Dennis", 25, "Contracting");

			ageComp age = new ageComp();
			System.out.println(age.compare(e1, e2));
			nameComp name = new nameComp();
			System.out.println(name.compare(e1, e2));
			deptComp dept = new deptComp();
			System.out.println(dept.compare(e2, e1));

		}

	}

}
