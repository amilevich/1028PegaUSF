package Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q7Driver {

	//Sort two employees based on their name, department, and age using the Comparator interface.
	public static void main(String[] args) {
		Employee e;
		ArrayList<Employee> ea = new ArrayList<Employee>();
		
		e = new Employee("aname", "adepartment", 10);
		ea.add(e);
		e = new Employee("anothername", "anotherdepartment", 5);
		ea.add(e);
		e = new Employee("name", "department", 2);
		ea.add(e);
		e = new Employee("blarg", "blarg", 4);
		ea.add(e);
		
		System.out.printf("Unsorted\n");
		for(int i = 0; i < ea.size(); i++) ea.get(i).print();
		
		System.out.printf("\nSorted by name\n");
		Collections.sort(ea, new NameComp());
		for(int i = 0; i < ea.size(); i++) ea.get(i).print();
		
		System.out.printf("\nSorted by department\n");
		Collections.sort(ea, new DepartmentComp());
		for(int i = 0; i < ea.size(); i++) ea.get(i).print();
		
		System.out.printf("\nSorted by age\n");
		Collections.sort(ea, new AgeComp());
		for(int i = 0; i < ea.size(); i++) ea.get(i).print();
	}
	
	static class NameComp implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			String name1 = o1.name;
			String name2 = o2.name;
			
			if(name1.compareTo(name2) < 0) return -1;
			else if(name1.equals(name2)) return 0;
			else return 1;
		}	
	}
	
	static class DepartmentComp implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			String d1 = o1.department;
			String d2 = o2.department;
			
			if(d1.compareTo(d2) < 0) return -1;
			else if(d1.equals(d2)) return 0;
			else return 1;
		}
	}
	
	static class AgeComp implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			int a1 = o1.age;
			int a2 = o2.age;
			
			if(a1 < a2) return -1;
			else if(a1 == a2) return 0;
			else return 1;
		}	
	}

}
