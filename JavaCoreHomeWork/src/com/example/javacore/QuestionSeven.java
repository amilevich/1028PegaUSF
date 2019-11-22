package com.example.javacore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * Sort two employees based on their name, department, and 
 * age using the Comparator interface.
 */

public class QuestionSeven {
	public static void main(String[]args) {
	
		ArrayList<Empl> empl = new ArrayList<>();
		
		empl.add(new Empl("Mario","HR",31));
		empl.add(new Empl("Jose","Administration",50));
		
		System.out.println("Employees not sorted:");
		for(int i = 0; i < empl.size(); i++) {
			System.out.println(empl.get(i));
		
		}
		// sorting data 
		System.out.println();
		System.out.println("Employes sorted by name:");
		Collections.sort(empl, new SortByName());
		for(int a = 0; a < empl.size(); a++) {
			System.out.println(empl.get(a));
		}
		
		System.out.println();
		System.out.println("Employees sorted by department:");
		Collections.sort(empl, new SortByDept());
		for(int b = 0; b < empl.size(); b++) {
			System.out.println(empl.get(b));
		}
		
		System.out.println();
		System.out.println("Employees sorted by age:");
		Collections.sort(empl, new SortByAge());
		for(int j = 0; j < empl.size(); j++) {
			System.out.println(empl.get(j));
		}
		}// end main.
		
	}// end main class
	
	
			class Empl { 
				private String name;
				private String deparment;
				private int age;
				
				
				public Empl(String name, String deparment, int age) {
					super();
					this.name = name;
					this.deparment = deparment;
					this.age = age;
				}


				@Override
				public String toString() {
					return "Employee name: " + name + ", deparment: " + deparment + ", age: " + age;
				}


				public String getName() {
					return name;
				}


				public void setName(String name) {
					this.name = name;
				}


				public String getDeparment() {
					return deparment;
				}


				public void setDeparment(String deparment) {
					this.deparment = deparment;
				}


				public int getAge() {
					return age;
				}


				public void setAge(int age) {
					this.age = age;
				}
			
		}// end empl
			
			class SortByName implements Comparator<Empl>{

				@Override
				public int compare(Empl empl1, Empl empl2) {
					
					return empl1.getName().compareTo(empl2.getName());//compares the name of both employees
				}
				
			}// end sort names class
			
			
			
			class SortByDept implements Comparator<Empl>{

				@Override
				public int compare(Empl empl1, Empl empl2) {
					
					return empl1.getDeparment().compareTo(empl2.getDeparment());//compares the departments of both employees
				}
				
			}// end sort department
			
			
			class SortByAge implements Comparator<Empl>{

				@Override
				public int compare(Empl empl1, Empl empl2) {
					
					return empl1.getAge() - empl2.getAge(); //compares the two employee's age
				}
			}// end age
			
	
	

