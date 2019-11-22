package com.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Workforce7 {

	public static void main(String[] args) 
	{
	
		Workforce7 wf = new Workforce7();
		
		wf.fill();
		System.out.println("Workforce:");
		wf.print();
		System.out.println("\nSorting by name");
		wf.sortName();
		System.out.println("Workforce:");
		wf.print();
		System.out.println("\nSorting by department");
		wf.sortDepartment();
		System.out.println("Workforce:");
		wf.print();
		System.out.println("\nSorting by age");
		wf.sortAge();
		System.out.println("Workforce:");
		wf.print();
	}
	
	LinkedList<Employee> employees = new LinkedList<Employee>();

	public void fill()
	{
		employees.add(new Employee("Jassie", "Programming", 25));
		employees.add(new Employee("James", "Design", 23));
		employees.add(new Employee("tex", "Art", 35));
	}
	
	public void sortName()
	{
		Collections.sort(employees, new NameSorter());
	}
	
	public void sortDepartment()
	{
		Collections.sort(employees, new DepartmentSorter());
	}
	
	public void sortAge()
	{
		Collections.sort(employees, new AgeSorter());
	}
	
	public void print()
	{
		for(int i = 0; i < employees.size(); i++)
			System.out.println(employees.get(i));
	}
	
	
}

class NameSorter implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
}

class DepartmentSorter implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getDepartment().compareToIgnoreCase(o2.getDepartment());
	}
}

class AgeSorter implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		if(o1.getAge() > o2.getAge())
			return 1;
		else if(o1.getAge() < o2.getAge())
			return -1;
		return 0;
	}
}

class Employee
{
	String m_name;
	String m_department;
	int m_age;

	public Employee()
	{
		m_name = null;
		m_department = null;
		m_age = 0;
	}
	public Employee(String _name, String _department, int _age) 
	{
		super();
		this.m_name = _name;
		this.m_department = _department;
		this.m_age = _age;
	}
	
	@Override
	public String toString() 
	{
		return "employee [name=" + m_name + ", department=" + m_department + ", age=" + m_age + "]";
	}
	
	//Accessors/getters
	public String getName() 
	{
		return m_name;
	}
	public String getDepartment() 
	{
		return m_department;
	}
	public int getAge() 
	{
		return m_age;
	}
	
	//mutators/setters
	public void setName(String _name) 
	{
		this.m_name = _name;
	}
	public void setDepartment(String _department) 
	{
		this.m_department = _department;
	}
	public void setAge(int _age) 
	{
		this.m_age = _age;
	}

	
}
