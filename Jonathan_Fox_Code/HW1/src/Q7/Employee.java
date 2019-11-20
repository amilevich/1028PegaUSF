package Q7;

public class Employee {
	public String name, department;
	public int age;
	
	public Employee(String n, String d, int a){
		name = n;
		department = d;
		age = a;
	}
	
	public void print() {
		System.out.printf("%s, %s, %d\n", name, department, age);
	}
}
