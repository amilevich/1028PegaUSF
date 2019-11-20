package bankapp;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

import users.Admin;
import users.Customer;
import users.Employee;

public class MainDriver {
	// prompts the user to stay on their current menu
	public static boolean runProgram(Scanner in) {
		System.out.println("Would you like to make another transaction?");
		String input = in.next();
		if (input.equals("yes")) {
			return true;
		} else {
			System.out.println("Thanks for banking with Bank of CZR, Have a wonderful day!");
			return false;
		}
	}

	// WELCOME UI
	public static void runProgramMenuUI() {
		System.out.println("			********************************");
		System.out.println("			*                              *");
		System.out.println("			*                              *");
		System.out.println("			*         Bank of CZR          *");
		System.out.println("			*                              *");
		System.out.println("			*                              *");
		System.out.println("			********************************");
		System.out.println();
	}

	// Instantiating new scanner object, used for all user interactions
	public static Scanner in = new Scanner(System.in);

	public static void writeAccountObjects() {
		try {
			FileOutputStream pafos = new FileOutputStream("pending_accounts.ser");
			ObjectOutputStream paoos = new ObjectOutputStream(pafos);

			FileOutputStream aafos = new FileOutputStream("approved_accounts.ser");
			ObjectOutputStream aaoos = new ObjectOutputStream(aafos);

			paoos.writeObject(BankApp.pendingAccounts);

			paoos.close();
			pafos.close();

			aaoos.writeObject(BankApp.approvedAccounts);

			aaoos.close();
			aafos.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void readAccountObjects() {

		try {
			FileInputStream pafis = new FileInputStream("pending_accounts.ser");
			ObjectInputStream paois = new ObjectInputStream(pafis);
			BankApp.pendingAccounts = (List) paois.readObject();
			paois.close();
			pafis.close();
			FileInputStream aafis = new FileInputStream("approved_accounts.ser");
			ObjectInputStream aaois = new ObjectInputStream(aafis);
			BankApp.approvedAccounts = (Map) aaois.readObject();
			aaois.close();
			aafis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Class Not Found");
			cnfe.printStackTrace();
		}
		System.out.println("Done");
		// Display content using Iterator
		Set set = BankApp.approvedAccounts.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.print("key: " + mapEntry.getKey() + " & Value: ");
			System.out.println(mapEntry.getValue());
		}

	}

	public static void main(String[] args) {

		readAccountObjects();

		boolean running = true;
		runProgramMenuUI();
		
		
		do {
			String programMenuSelection = " ";
			System.out.println(
					"Are you an a Customer, Employee or Administrator? Please select one of the following options: ");
			System.out.println();
			System.out.println("Customer - CUS ");
			System.out.println("Employee - EMP ");
			System.out.println("Administrator - ADM");
			System.out.println();
			try {
				programMenuSelection = in.nextLine();
				in.nextLine();
				switch (programMenuSelection) {
				case "CUS":
					Customer.customerLogin(in); // Accesses the customer menu
					break;
				case "EMP":
					Employee.employeeLogin(in); // Accesses the employee login
					break;
				case "ADM":
					Admin.adminLogin(in); // Access the bank admin login
					break;
				}
				running = runProgram(in);
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Invalid input, please try again");
				in.nextLine();
			}
		} while (running);
		System.out.println("LOGGED OUT");

		writeAccountObjects();

	}
	
	public static void viewProgramMenu() {
		
	}
}