package problem7;
import java.util.Comparator;

public class Employee {
	int age; 
	String name, department; 
	public Employee(String name, String department, int age) { 
		this.name = name; 
		this.department = department; 
		this.age= age; 
	} 
}

class SortByName implements Comparator<Employee> { 
	public int compare(Employee a, Employee b) { 
		return a.name.compareTo(b.name); 
	} 
}

class SortbyDepartment implements Comparator<Employee> { 
	public int compare(Employee a, Employee b) { 
		return a.department.compareTo(b.department); 
	} 
} 

class SortbyAge implements Comparator<Employee> { 
	public int compare(Employee a, Employee b) { 
		return a.age-b.age; 
	} 
} 
