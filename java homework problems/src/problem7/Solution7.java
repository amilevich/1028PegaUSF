package problem7;

import java.util.ArrayList;
import java.util.Collections;

public class Solution7 {
	
    public static void main (String[] args) { 
        ArrayList<Employee> array = new ArrayList<Employee>(); 
        array.add(new Employee("daniel", "marketing" , 25)); 
        array.add(new Employee("patric", "HR", 30)); 
        array.add(new Employee("coco", "sales" , 20)); 
  
        Collections.sort(array, new SortbyAge()); 
        System.out.println("\nSorted by age"); 
        for (int i=0; i<array.size(); i++) {
        	 System.out.println(array.get(i)); 
        }
        Collections.sort(array, new SortByName()); 
        System.out.println("\nSorted by name"); 
        for (int i=0; i<array.size(); i++) {
        	 System.out.println(array.get(i)); 
        }
        Collections.sort(array, new SortbyDepartment()); 
        System.out.println("\nSorted by department"); 
        for (int i=0; i<array.size(); i++) {
        	 System.out.println(array.get(i)); 
        }
    } 
}