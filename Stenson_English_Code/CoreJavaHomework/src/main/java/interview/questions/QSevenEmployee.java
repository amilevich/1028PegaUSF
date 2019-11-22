package interview.questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 class QSevenEmployee{

	String name;
	Integer age;
	String department;

	public QSevenEmployee(String name, int age, String department) {

		this.name = name;
		this.age = age;
		this.department = department;

	}

	public String toString() {
		return name + " " + age + " " + department;
	}
	
	public static void main(String[] args) {

		ArrayList<QSevenEmployee> empList = new ArrayList<QSevenEmployee>();

		empList.add(new QSevenEmployee("Jason", 20, "Recruiting")); 
		empList.add(new QSevenEmployee("Ann", 27, "Testing"));

		
		Collections.sort(empList, new sortName());
		System.out.println("Sort by name");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
		System.out.println();

		Collections.sort(empList, new sortAge());
		System.out.println("Sort by age");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
		System.out.println();

		Collections.sort(empList, new sortDepartment()); 
		System.out.println("Sort by department"); 
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
		System.out.println();
	
}
}

	class sortName implements Comparator<QSevenEmployee> { 
		public int compare(QSevenEmployee o1, QSevenEmployee o2) { 
			return o1.name.compareTo(o2.name);
		}
	}

	class sortDepartment implements Comparator<QSevenEmployee>{
		public int compare(QSevenEmployee o1, QSevenEmployee o2) {

			return o1.department.compareTo(o2.department);
		}
	}

	class sortAge implements Comparator<QSevenEmployee> {
		public int compare(QSevenEmployee o1, QSevenEmployee o2) {

			return o1.age.compareTo(o2.age);
		}
	
	}
