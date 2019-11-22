package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainDriver {

	public static void main(String[] args) {
		
		
		//Compares the names
		
		Comparator <Employees> nameComparator = new Comparator<Employees>()
		{

			@Override
			public int compare(Employees o1, Employees o2) {
				//return numerical value to arrange
			return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
			
			}
		};
		
		
		Comparator <Employees> departmentComparator = new Comparator<Employees>()
		{

			@Override
			public int compare(Employees o1, Employees o2) {
				//return numerical value to arrange
			return o1.getDepartment().toUpperCase().compareTo(o2.getDepartment().toUpperCase());
			
			}
		};
		
		
		Comparator <Employees> ageComparator = new Comparator<Employees>()
		{

			@Override
			public int compare(Employees o1, Employees o2) {
				//return numerical value to arrange
			return o1.getAge()-o2.getAge();
			
			}
		};
		
		
	
		// TODO Auto-generated method stub
		
		Employees e1 = new Employees("John", 20, "Finance");
		Employees e2 = new Employees("david", 12, "WebDev");
		Employees e5 = new Employees("davis", 29, "noDev");
		Employees e3 = new Employees("james", 52, "Logistics");
		Employees e4 = new Employees("Wyane", 82, "onboarding");
		
		
		List <Employees> listsEmployees = new ArrayList<Employees>();
		listsEmployees.add(e1);
		listsEmployees.add(e2);
		listsEmployees.add(e3);
		listsEmployees.add(e4);
		listsEmployees.add(e5);
		
		
		
		Collections.sort(listsEmployees, nameComparator);
		Collections.sort(listsEmployees, departmentComparator);
		Collections.sort(listsEmployees, ageComparator);
		
		
		
	
		System.out.println(listsEmployees);
		//nameComparator.compare(e1, e2);
		//System.out.println(listsEmployees);
		
		
	}

	


	

	

}
