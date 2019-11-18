package com.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Administrater {
	
	private static final long serialVersionUID = 7497019669544851685L;
	//declare private employee variables
	private String user;
	private String password;
	private String fName;
	private String lName;
	private int employeeId;
	Scanner input = new Scanner(System.in);
	
	//Create a constructor
	//public () {
		//super();
	//}
	
	//create getters
	//-----------------------------------------------------------------
	//This method retrieves employee user
	
	public String getUser() {
		return user;
	}
	
	

	//This method retrieves employee password
	public String getPassword() {
		return password;
	}
	
	//This method retrieves employee first name
	public String getfName() {
		return fName;
	}
	//This method retrieves employee last name
	public String getlName() {
		return lName;
	}
	
	//This method retrieves employee id
	public int getEmployeeId() {
		return employeeId;
		
	}
	
	
	//This method set the employee user name
	public void setUser(String user) {
		this.user = user;
	}
	//This method set the employee password
	public void setPassword(String password) {
		this.password = password;
	}
	//This method set the employee first name
	public void setfName(String fName) {
		this.fName = fName;
	}
	//This method set the employee last name
	public void setlName(String lName) {
		this.lName = lName;
	}
	//This method set the employee id
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
	
//	//creating method that read and write file
//		public static void writeEmployee(String name, Object object) {
//			try(ObjectOutputStream employee =new ObjectOutputStream(new FileOutputStream(name))){
//				employee.writeObject(object);
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//				
//			
//		}
//		//Creating Method that read from to the file
//		public static void readEmployee1(String name) {
//			try(ObjectInputStream employee1 =new ObjectInputStream(new FileInputStream(name))){
//				employee1.readObject();
//			}catch(IOException e) {
//				e.printStackTrace();
//			}catch(ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//	
//	
//	
//	
//		}
//		
//		public void employeeMenu() {
//			
//			char option;
//			System.out.println("________________________________________________________________________| ");
//			System.out.println(" Choose an option: ");
//			System.out.println(" 'a' : View Customers ");
//			
//			System.out.println(" 'b' : Account status (Approved/Denied");
//			System.out.println(" 'c' : Go Back to he previous menu");
//			System.out.println(" 'q' : Quit");
//			System.out.print(" Enter option here: ");
//
//			String input1;
//			do {
//				input1 = input.next();
//				option = input1.charAt(0);
//				switch (option) {
//				case 'a':
//					// readObject(Filename);
//					for (Customer c : Account.customerList) {
//						System.out.println(c);
//					}
//
//					break;
//				case 'b':
//					Administrater c= new Administrater();
//					c.approved();
//
//					break;
//				case 'c':
//					c.writeCustomer(Filename, customerList);
//					bankMenu();
//
//					break;
//				case 'q':
//
//					bankMenu();
//
//					break;
//				default:
//					System.out.println("You entered the wrong option");
//				}
//			} while (option != 'q');
//
//		}

//		public void bankMenu() {
//}

//}
