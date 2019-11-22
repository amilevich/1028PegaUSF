package com.Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q7 {

	public static void main(String[] args) {
		// Sort two employees based on their name, department, and age using the Comparator interface.
		
		ArrayList<Emp> arr = new ArrayList<Emp>(); 
        arr.add(new Emp("ahmet", "sanayi", 42));  
        arr.add(new Emp("doga", "hizmet", 24));
        
        System.out.println("Unsorted employees:"); 
        for (int i=0; i<arr.size(); i++) 
            System.out.println(arr.get(i));
        
        Collections.sort(arr, new NameSort());
        
        System.out.println("\nSorted by Name:"); 
        for (int i=0; i<arr.size(); i++) 
            System.out.println(arr.get(i));
        
        Collections.sort(arr, new DepartmentSort());
        
        System.out.println("\nSorted by Department:"); 
        for (int i=0; i<arr.size(); i++) 
            System.out.println(arr.get(i));
        
        Collections.sort(arr, new AgeSort());
        
        System.out.println("\nSorted by Age:"); 
        for (int i=0; i<arr.size(); i++) 
            System.out.println(arr.get(i));
	}

}

class Emp{
	
	// getters and setters , private variable decleration
	private String name;
	private String dept;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Emp(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	
}
// comparator interface implementation
class AgeSort implements Comparator<Emp> 
{ 
    public int compare(Emp a, Emp b) 
    { 
        return a.getAge()-b.getAge(); 
    } 
} 
class DepartmentSort implements Comparator<Emp> 
{ 
    
    public int compare(Emp a, Emp b) 
    { 
        return a.getDept().compareTo(b.getDept()); 
    } 
} 
  
class NameSort implements Comparator<Emp> 
{ 
   
    public int compare(Emp a, Emp b) 
    { 
        return a.getName().compareTo(b.getName()); 
    } 
} 