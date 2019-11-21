package Q7SortTwoEmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortTwoEmp {

	public static void main(String[] args) {
		// Sort two employees based on their name, department, and age using the Comparator interface.
		
		ArrayList<Emp> ar = new ArrayList<Emp>(); 
        ar.add(new Emp("john", "accounting", 30)); 
        ar.add(new Emp("jane", "marketing", 24)); 
        ar.add(new Emp("joe", "human resources", 35));
        
        System.out.println("Unsorted employees:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        Collections.sort(ar, new SortByName());
        
        System.out.println("\nSorted by Name:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        Collections.sort(ar, new SortByDepartment());
        
        System.out.println("\nSorted by Department:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        Collections.sort(ar, new SortByAge());
        
        System.out.println("\nSorted by Age:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
	}

}

class Emp{
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
		return "Emp [name= " + name + ", \tdept= " + dept + ", \tage= " + age + "]";
	}
}
class SortByAge implements Comparator<Emp> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Emp a, Emp b) 
    { 
        return a.getAge()-b.getAge(); 
    } 
} 
class SortByDepartment implements Comparator<Emp> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Emp a, Emp b) 
    { 
        return a.getDept().compareTo(b.getDept()); 
    } 
} 
  
class SortByName implements Comparator<Emp> 
{ 
    // Used for sorting in ascending order of 
    // roll name 
    public int compare(Emp a, Emp b) 
    { 
        return a.getName().compareTo(b.getName()); 
    } 
} 
