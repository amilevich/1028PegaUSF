package firsthw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class quest7 {
	
	public static void main(String[] args) {
		
		
		ArrayList<emp> ar = new ArrayList<emp>(); 
        ar.add(new emp("jake", 14, "student")); 
        ar.add(new emp("gabe", 43, "clown")); 
        ar.add(new emp("blake", 50, "anchor"));
        
        System.out.println("employees:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        Collections.sort(ar,new Name());
        
        System.out.println("Name:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        Collections.sort(ar,new Age());
        
        System.out.println("Age:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        Collections.sort(ar,new Department());
        
        System.out.println("Department:"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i));
        
        
	}

}
	





class emp{
	
	private String name;
	private int age;
	private String dept;
	
	
	public emp(String name, int age, String dept) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "emp [name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}
}
	class Name implements Comparator<emp> 
	{ 
	     
	    public int compare(emp a, emp b) 
	    { 
	        return a.getName().compareTo(b.getName()); 
	    } 
	}
	class Age implements Comparator<emp> 
	{ 
	    
	    public int compare(emp a, emp b) 
	    { 
	        return a.getAge()-b.getAge(); 
	    } 
	} 
	class Department implements Comparator<emp> 
	{ 
	    
	    public int compare(emp a, emp b) 
	    { 
	        return a.getDept().compareTo(b.getDept()); 
	    } 
	} 
	  
	
	
	
	
