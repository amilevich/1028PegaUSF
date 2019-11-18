package com.project.pt1;


/*
 * This will preload our files with a sample customer,employee, and administrator.
 */

import java.io.FileOutputStream;
import java.util.ArrayList;

import java.io.IOException;
import java.io.ObjectOutputStream;


public class testDriver {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

	
		String employees = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser";
		String customers = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		String admins = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/admin/admin.ser";

		ArrayList<Admin> administrator = new ArrayList<Admin>();
		Admin boss = new Admin("caio","1234");
		administrator.add(boss);
		writeAdmin(administrator);
		
		
		ArrayList<Employee> test = new ArrayList<Employee>();
		Employee worker = new Employee("caio","1234");
		test.add(worker);
		writeEmployee(test);
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer caio = new Customer("caio","1234");
		customerList.add(caio);
		writeCustomer(customerList);
	
		
	}
public static void writeAdmin(ArrayList<Admin> x){
	String z = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/admin/admin.ser";
		try {
			FileOutputStream fop=new FileOutputStream(z);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(x);
			
			oos.close();
			fop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
public static void writeCustomer(ArrayList<Customer> x){
	String z = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		try {
			FileOutputStream fop=new FileOutputStream(z);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(x);
			
			oos.close();
			fop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void writeEmployee(ArrayList<Employee> x){
	String z = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser";
		try {
			FileOutputStream fop=new FileOutputStream(z);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(x);
			
			oos.close();
			fop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}


}

