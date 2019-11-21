package src.Question7;

import java.util.Arrays;
import java.util.Comparator;

public class MainEmployee extends Employees{

	public static void main(String[] args) {
		String name = "Charlie";
        String name1 = "Mac";

        String department = "Janitor";
        String department2 = "Security";

        int age = 27;
        int age2 = 28;
        //creating new employees with their name,depart, & age
        Employees employee1 = new Employees(name,department,age);
        Employees employee2 = new Employees(name1,department2,age2);
        //storing data to the array
        Employees[] myArray = {employee1,employee2};
        //Comparing the age, depart, and name of both employees
        CompareAge checkAge = new CompareAge();
        CompareDepartment checkDep = new CompareDepartment();
        NameCompare checkName = new NameCompare();
        
        //Then sorting thru each array to compare both employees
        Arrays.sort(myArray,checkAge);
        System.out.println("Sort by age: ");
        for(Employees employee : myArray){
            System.out.println("Age: "+employee.getAge()+" Name: "+employee.getName()+" Department: "+ employee.getDepartment());
        }

        Arrays.sort(myArray,checkDep);
        System.out.println("Sort by Department: ");
        for(Employees employee : myArray){
            System.out.println("Age: "+employee.getAge()+" Name: "+employee.getName()+" Department: " +employee.getDepartment());
        }

        Arrays.sort(myArray,checkName);
        System.out.println("Sort by Name: ");
        for(Employees employee : myArray){
            System.out.println("Age: "+employee.getAge()+" Name: "+employee.getName()+" Department: "+employee.getDepartment());
        }

	}
	
	public MainEmployee(String name, String department, int age) {
		super(name, department, age);
	}

	public static class CompareDepartment implements Comparator<Employees> {

        public int compare(Employees o1, Employees o2) {
            if (o1.getDepartment().compareTo(o2.getDepartment()) > 0) {
                return 1;
            } else if (o1.getDepartment().compareTo(o2.getDepartment()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

    }
	 public static class NameCompare implements Comparator<Employees> {

	        public int compare(Employees o1, Employees o2) {
	            if (o1.getName().compareTo(o2.getName()) > 0) {
	                return 1;
	            } else if (o1.getName().compareTo(o2.getName()) < 0) {
	                return -1;
	            } else {
	                return 0;
	            }
	        }

	    }
	    public static class CompareAge implements Comparator<Employees> {

	     
	        public int compare(Employees o1, Employees o2) {
	            if (o1.getAge() > o2.getAge()) {
	                return 1;
	            } else if (o1.getAge() < o2.getAge()) {
	                return -1;
	            } else {
	                return 0;
	            }
	        }

	    }
}
