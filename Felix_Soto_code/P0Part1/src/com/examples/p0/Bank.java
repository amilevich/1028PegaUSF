package com.examples.p0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private Admin admin;
	Employee employee;
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	private static Double totalMoneyDeposited = 0.0;
	private static boolean bankStarted = false;
	public static Bank bank;
	public static int customerID = 0;

	private Bank() {
		admin = new Admin("Felix Soto", "admin", "adminpass");
		admin.bank = this;
		bank = this;
		bankStarted = true;
		customers.add(new Customer("", "", ""));
		
		employee = new Employee("", "employee", "employeepass");
		employee.bank = this;
		bank = this;
		bankStarted = true;
		customers.add(new Customer("", "", ""));
	}

	public static Bank getBank() {
		if (bankStarted == false) {
			return new Bank();
		} else
			return bank;
	}

	
	public static Double getTotalMoneyDeposited() {
		return totalMoneyDeposited;
	}

	

	public static void setTotalMoneyDeposited(Double amount) {
		totalMoneyDeposited = amount;
	}

	public void showBankDetails(Admin admin) {
		if (admin != this.admin)
			return;
		System.out.println("Total number of accounts: " + customers.size());
		System.out.println("Total number of registrered accounts: " + getAccountsCount());
		System.out.println("Total money deposited: " + getTotalMoneyDeposited());
	}
	
	public void showBankDetails(Employee employee) {
		if (employee != this.employee)
			return;
		System.out.println("Total number of accounts: " + customers.size());
		System.out.println("Total number of registered customers: " + getAccountsCount());
		System.out.println("Total money deposited: " + getTotalMoneyDeposited());
	}

	public Integer getAccountsCount() {
		Integer count = 0;
		for (Customer cus : customers) {
			count += cus.getNoOfAccount();
		}
		return count;
	}
	public void addCustomers() throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String fullName;
		String userName;
		String password;

		// input name
		do {
			System.out.println("Your full name please?");
			fullName = new String(sc.nextLine().toUpperCase());
			if (fullName.matches("[A-Z]+\\s[A-Z]+")) {
				System.out.println("Welcome " + fullName);
				break;
			} else {
				System.out.println("Sorry the format of name should be \"FirstName LastName\"");
			}
		} while (true);

		// input username
		do {
			System.out.println("Choose a username containing only letters.");
			userName = new String(sc.nextLine());
			if (userName.matches("[a-zA-Z]+")) {
				if (checkUsername(userName)) {
					System.out.println("Username already exists. Please Choose another.");
				} else {
					System.out.println("Your username is: " + userName);
					break;
				}
			} else {
				System.out.println("Invalid username.");
			}
		} while (true);

		// input password
		do {
			System.out.println("Please choose a password.");
			password = new String(sc.nextLine());
			System.out.println("Type your chosen password again.");
			String temp = new String(sc.nextLine());
			if (password.equals(temp)) {
				System.out.println("Your password has been chosen succesfully.");
				break;
			} else {
				System.out.println("Sorry, the passwords didn't match, please try again");
			}
		} while (true);

		Customer newCustomer = new Customer(fullName, userName, password);
		if (customers.add(newCustomer)) {
			System.out.println("You are now our customer.");
			newCustomer.showCustomerDetails();
		}
	}

	private boolean checkUsername(String userName) {
		for (Customer customer : customers) {
			if (customer.userName.equals(userName))
				return true;
		}
		return false;
	}

	public Customer customerLogin() throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Customer temp = null;
		String userName;
		String password;
		Integer input = 1;
		do {
			System.out.println("Enter username");
			userName = new String(sc.nextLine());
			System.out.println("Enter password.");
			password = new String(sc.nextLine());
			temp = null;
			for (Customer cust : customers) {
				if (cust.userName.equals(userName) && cust.password.equals(password)) {
					temp = cust;
				}
			}
			if (temp == null) {
				System.out.println("Your username and password didnt match.");
				do {
					System.out.println("Press 1 to try again");
					System.out.println("Press 0 to go back to previous menu");
					try {
						input = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Select one of the above options.");
						continue;
					}
					break;
				} while (true);
			} else {
				System.out.println("Logging in. . .");
				break;
			}
		} while (input != 0);
		return temp;
	}

	public Admin adminLogin() throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Admin temp = null;
		String userName;
		String password;
		Integer input = 1;
		do {
			System.out.println("Enter username");
			userName = new String (sc.nextLine());
			System.out.println("Enter password.");
			password = new String (sc.nextLine());
			temp = null;
			if (admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {
				temp = admin;
			}
			if (temp == null) {
				System.out.println("username and password didnt match.");
				System.out.println("Press 1 to try again");
				System.out.println("Press 0 to go back to previous menu");
				input = Integer.parseInt(sc.nextLine());
			} else {
				System.out.println("Logging in. . .");
				break;
			}
		} while (input != 0);
		return temp;
	}

	public void showAllAccounts(Admin admin) {
		if (admin != this.admin)
			return;
		for (Customer cus : customers) {
			for (Account acc : cus.getAccounts()) {
				System.out.println("Account No: " + acc.getAccountNumber() + ", Name: " + cus.fullName + ", Username: " +   cus.userName  + ", Password: " + cus.password + ", Balance: $" + acc.getBalance()+ ", Account status: " + acc.getStatus() + ".");
			}
		}
	}
		public void approveAccounts(Admin admin) {
			if (admin != this.admin)
				return;
			Account.status = "Active";		
		   System.out.println("the costumer(s) have been aproved");
		}
	
	public Employee employeeLogin() throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Employee temp = null;
		String userName;
		String password;
		Integer input = 1;
		do {
			System.out.println("Enter username");
			userName = new String(sc.nextLine());
			System.out.println("Enter password.");
			password = new String(sc.nextLine());
			temp = null;
			if (employee.getUserName().equals(userName) && employee.getPassword().equals(password)) {
				temp = employee;
			}
			if (temp == null) {
				System.out.println("username and password didnt match.");
				System.out.println("Press 1 to try again");
				System.out.println("Press 0 to go back to previous menu");
				input = Integer.parseInt(sc.nextLine());
			} else {
				System.out.println("Logging in..");
				break;
			}
			
		} while (input != 0);
		return temp;
	}

	public void showAllAccounts(Employee employee) {
		if (employee != this.employee)
			return;
		for (Customer cus : customers) {
			for (Account acc : cus.getAccounts()) {
				System.out.println("Account No: " + acc.getAccountNumber() + ", Name: " + cus.fullName + ", Username: " +   cus.userName  + ", Balance: $" + acc.getBalance()+ ", Account status: " + acc.getStatus()+ ".");
			}
		}				
	}
	public void approveAccounts(Employee employee) {
		if (employee != this.employee)
			return;
		Account.status = "Active";		
	   System.out.println("the costumer(s) have been aproved");
	}
}