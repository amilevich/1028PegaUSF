package com.project0.maindriver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.project0.dao.BankDaoImpl;
import com.project0.model.Account;
import com.project0.model.BackEndTerminal;
import com.project0.model.Customer;
import com.project0.model.DataBaseAccounts;
import com.project0.model.DataBaseApplications;
import com.project0.model.DataBaseCustomers;
import com.project0.model.DataBaseEmployees;
import com.project0.model.Employee;
import com.project0.model.FrontEndTerminal;

public class MainDriver {
	/*
	 * All information should be persisted using text files and serialization All
	 * basic validation should be done, such as trying to input negative amounts,
	 * overdrawing from accounts etc.
	 * 
	 * 100% test coverage is expected using J-Unit You should be using TDD(Test
	 * Driven Development). Alex has said that we are actually going for %50 
	 * JUnit testing for methods and not expected to do TDD.
	 * 
	 * Logging should be accomplished using Log4J All transactions should be logged
	 */
	
	public static void serialize(String fileOut) {
	     
	}
	
	public static boolean isNegative(double d) {
	     return Double.doubleToRawLongBits(d) < 0;
	}
	
	public static boolean isEqualToString(String input, String comparedTo) {
		return input.equals(comparedTo);
	}
	
	public static void incrementVariable(double input) {
		input++;
	}
	public static void incrementVariable(int input) {
		input++;
	}
	
	private static void EmployeeDataBaseTestValues() {
		DataBaseEmployees.dBEmp.putMapEmployees(0, new Employee("AdminEmployee", "password"));
		//System.out.println(DataBaseEmployees.dBEmp.getMap(0).getUserName() + " " + DataBaseEmployees.dBEmp.getMapEmployees().size());
		DataBaseEmployees.dBEmp.putMapEmployees(1, new Employee("Wally", "password"));
		//System.out.println(DataBaseEmployees.dBEmp.getMap(1).getUserName() + " " + DataBaseEmployees.dBEmp.getMapEmployees().size());
		DataBaseEmployees.dBEmp.putMapEmployees(2, new Employee("Billy", "password"));
		//System.out.println(DataBaseEmployees.dBEmp.getMap(2).getUserName() + " " + DataBaseEmployees.dBEmp.getMapEmployees().size());
		//DataBaseEmployees.serializeDataBase();
	}
	
	private static void ApplicationDataBaseTestValues() {
		Set<Integer> a = new HashSet<Integer>(); a.add(3);
		Set<Integer> b = new HashSet<Integer>(); b.add(4);
		Set<Integer> c = new HashSet<Integer>(); c.add(5);
		DataBaseApplications.dBApps.putMap(4, new Account(4, b, 100.0, false));
		DataBaseApplications.dBApps.putMap(5, new Account(5, c, 10.0, false));
		DataBaseApplications.dBApps.putMap(3, new Account(6, a, 1000.0, false));
		//DataBaseApplications.serializeDataBaseApplication();
	}
	
	private static void ActiveAccountDataBaseTestValues() {
		Set<Integer> a = new HashSet<Integer>(); a.add(0);
		Set<Integer> b = new HashSet<Integer>(); b.add(1); b.add(3);
		Set<Integer> c = new HashSet<Integer>(); c.add(2); c.add(1);
		DataBaseAccounts.dBAccs.putMap(0, new Account(0, a, 1000.0, true));
		DataBaseAccounts.dBAccs.putMap(1, new Account(1, b, 100.0, true));
		DataBaseAccounts.dBAccs.putMap(2, new Account(2, c, 10.0, true));
		//DataBaseAccounts.serializeDataBaseAccount();
	}
	
	private static void CustomerDataBaseTestValues() {
		DataBaseCustomers.dBCus.putMapCustomers(0, new Customer("AdminCustomer", "password", "Debug", "Min"));
		DataBaseCustomers.dBCus.putMapCustomers(1, new Customer("Wally", "password", "Joe", "Hill"));
		DataBaseCustomers.dBCus.putMapCustomers(2, new Customer("Billy", "password", "Bo", "Dallas"));
		DataBaseCustomers.dBCus.putMapCustomers(3, new Customer("Pacifica", "password", "Po", "Joe"));
		DataBaseCustomers.dBCus.putMapCustomers(4, new Customer("Polly", "password", "Moe", "Toe"));
		DataBaseCustomers.dBCus.putMapCustomers(5, new Customer("Doly", "password", "Go", "Bo"));
		DataBaseCustomers.dBCus.getMap(0).addIdAccount(DataBaseAccounts.dBAccs.getMap(0).getAccountId());
		DataBaseCustomers.dBCus.getMap(1).addIdAccount(DataBaseAccounts.dBAccs.getMap(1).getAccountId());
		DataBaseCustomers.dBCus.getMap(2).addIdAccount(DataBaseAccounts.dBAccs.getMap(2).getAccountId());
		DataBaseCustomers.dBCus.getMap(1).addIdAccount(DataBaseAccounts.dBAccs.getMap(2).getAccountId());
		DataBaseCustomers.dBCus.getMap(3).addIdAccount(DataBaseAccounts.dBAccs.getMap(1).getAccountId());
		DataBaseCustomers.dBCus.getMap(4).addIdAccount(DataBaseAccounts.dBAccs.getMap(2).getAccountId());
		DataBaseCustomers.dBCus.getMap(5).addIdAccount(DataBaseAccounts.dBAccs.getMap(2).getAccountId());
		//DataBaseCustomers.serializeDataBaseCustomer();
	}
	
	private static void adminValues() {
		Set<Integer> a = new HashSet<Integer>(); a.add(0);
		DataBaseEmployees.dBEmp.putMapEmployees(0, new Employee("AdminEmployee", "password"));
		DataBaseAccounts.dBAccs.putMap(0, new Account(0, a, 1000.0, true));
		DataBaseCustomers.dBCus.putMapCustomers(0, new Customer("AdminCustomer", "password", "Debug", "Min"));
		//DataBaseEmployees.deserializeDataBaseEmployee();
		//DataBaseApplications.deserializeDataBaseApplication();
		//DataBaseAccounts.deserializeDataBaseAccount();
		//DataBaseCustomers.deserializeDataBaseCustomer();
	}
	
	public static void main(String[] args) {
		// Main Parameters:
		// Front End Mode: front
		// Back End Mode: back
		// Debug Mode can be anything within reason
		Scanner sc = new Scanner(System.in);
		if(isEqualToString(args[0], "front")) {
			// System.out.println("Front End System Engaged!");
			adminValues();
			FrontEndTerminal.loginScreen();
		} else if(isEqualToString(args[0], "back")) {
			// System.out.println("Back End System Engaged!");
			adminValues();
			BackEndTerminal.loginScreen();
		} else {
			ApplicationDataBaseTestValues();
			ActiveAccountDataBaseTestValues();
			CustomerDataBaseTestValues();
			EmployeeDataBaseTestValues();
			//System.out.println("A");
			BankDaoImpl bankDaoImpl = new BankDaoImpl();
			bankDaoImpl.insertCustomer(DataBaseCustomers.dBCus.getMap(0));
			//System.out.println("A1");
			bankDaoImpl.insertCustomer(DataBaseCustomers.dBCus.getMap(1));
			//System.out.println("A2");
			bankDaoImpl.insertCustomer(DataBaseCustomers.dBCus.getMap(2));
			//System.out.println("A3");
			bankDaoImpl.insertCustomer(DataBaseCustomers.dBCus.getMap(3));
			//System.out.println("A4");
			bankDaoImpl.insertCustomer(DataBaseCustomers.dBCus.getMap(4));
			//System.out.println("A5");
			bankDaoImpl.insertCustomer(DataBaseCustomers.dBCus.getMap(5));
			//System.out.println("B");
			System.out.println(bankDaoImpl.selectCustomerByName("Pacifica").getLastName());
			//System.out.println("C");
			System.out.println(bankDaoImpl.selectAllCustomers().toString());
			//System.out.println("D");
			DataBaseCustomers.dBCus.getMap(2).setLastName("Doey");
			//System.out.println("E");
			bankDaoImpl.updateCustomer(DataBaseCustomers.dBCus.getMap(2));
			//System.out.println("F" );
			System.out.println(bankDaoImpl.selectCustomerByName("Wally").getFullName());
			//System.out.println("G");
			bankDaoImpl.deleteCustomer(DataBaseCustomers.dBCus.getMap(3));
			//System.out.println("H");
			System.out.println(bankDaoImpl.selectAllCustomers());
			//System.out.println("I");
					
			//FrontEndTerminal.loginScreen(sc);
			//BackEndTerminal.loginScreen(sc);
		}
		sc.close();
	}

}

