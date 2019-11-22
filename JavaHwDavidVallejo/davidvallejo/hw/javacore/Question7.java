package davidvallejo.hw.javacore;

import java.util.Comparator;

/*
 * 
 * Question 7: Sort two employees based on their name, department, and age using the
 * Comparator interface.
 * 
 */
public class Question7 {
	private String name;
	private String department;
	private Integer age;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return " [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public static void main(String[] args) {

		Question7 obj1 = new Question7(); //instantiating an object obj1 of type Question7 that I then populate with properties related tot he object
		Question7 obj2 = new Question7(); //instantiating an object obj2 of type Question7 that I then populate with properties related tot he object
		obj1.name = "Jeff";
		obj1.age = 23;
		obj1.department = "Marketing";
//two objects being instantiated 
		obj2.name = "Jane";
		obj2.age = 34;
		obj2.department = "Tech";

		System.out.println("name: ");
		if (Question7.nameComp.compare(obj1, obj2) > 0) {
			System.out.println("1. " + obj1.toString());
			System.out.println("2. " + obj2.toString());
		} else {
			System.out.println("1. " + obj2.toString());
			System.out.println("2. " + obj1.toString());
		}

		System.out.println("department name: ");
		if (Question7.departmentComp.compare(obj1, obj2) > 0) {
			System.out.println("1. " + obj1.toString());
			System.out.println("2. " + obj2.toString());
		} else {
			System.out.println("1. " + obj2.toString());
			System.out.println("2. " + obj1.toString());
		}

		System.out.println("age: ");
		if (Question7.ageComp.compare(obj1, obj2) > 0) {
			System.out.println("1. " + obj1.toString());
			System.out.println("2. " + obj2.toString());
		} else {
			System.out.println("1. " + obj2.toString());
			System.out.println("2. " + obj1.toString());
		}
	}

	public static final Comparator<Question7> nameComp = new Comparator<Question7>() {
     // using the comparator api to access the comparing functions 
		@Override
		public int compare(Question7 arg0, Question7 arg1) {
			return (arg1.name).compareTo(arg0.name);
		}
	};
	public static final Comparator<Question7> departmentComp = new Comparator<Question7>() {

		@Override
		public int compare(Question7 arg0, Question7 arg1) {
			return (arg1.department).compareTo(arg0.department);
		}
	};

	public static final Comparator<Question7> ageComp = new Comparator<Question7>() {

		@Override
		public int compare(Question7 arg0, Question7 arg1) {
			
			return (arg1.age) - (arg0.age);
		}
	};
}
