package com.folder.bank;


public class Employees extends Customers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5933936665043828865L;
	private int employeeId;
	private int totalBalance;
	private String accountType;
	private String emUsername = "eM";
	private String emPassword = "eM";
	
	
	//Old Code
//	static Customers employee = new Customers();
//	static ArrayList accountsApproved = new ArrayList();
	
//	public static void employeePrintInfo() {
//		System.out.println("1. Get All Accounts Info");
//		System.out.println("2. Accept/Decline Accounts");
//		System.out.println("3. Back");
//		int option = input.nextInt();
//		switch(option) {
//		
//		case 1 : 
//			System.out.println("User Id: " + employee.getId() + "\n" + "Balance: " + employee.getTotalBalance() + "\n" + "Account Type: " + employee.getAccountType() + "\n");
//			System.out.println("3. Go back");
//			int options = input.nextInt();
//			
//			if( options != 1 && options !=2) {
//				System.out.println(options);
//				employeePrintInfo();
//			}
//			
//		case 2 : 
//			System.out.println("Accept/Decline Account Menu");
//			System.out.println("Pending account count: " + accountsPending.size() + "\n");
//			
//			for(int i = 0; i <accountsPending.size(); i++) {
//				System.out.println(accountsPending.get(i));
//			}
//			System.out.println("3. Go back");
//			int optionss = input.nextInt();
//			
//			if( optionss != 1 && optionss !=2) {
//				employeePrintInfo();
//			}
//			
//		case 3 :
//			
//		
//		}
		
	
//	}
	
	//Getters and Setters
	// Get ID
		public int getEmployeeId() {
			return employeeId;
		}
		// Set ID Employee
		public void setEmployeeId(int employeeId) {
			this.employeeId += 1;
		}
		// Get Total Balance Employee
		public int getTotalBalance() {
			return totalBalance;
		}
		// Set Total Balance Employee
		public void setTotalBalance(int totalBalance) {
			this.totalBalance = totalBalance;
		}
		// Get Account Type Employee
		public String getAccountType() {
			return accountType;
		}
		// Set Account Type Employee
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		// Get User name Employee
		public String getEmUsername() {
			return emUsername;
		}
		// Set User name Employee
		public void setEmUsername(String username) {
			this.emUsername = username;
		}
		// Get Password Employee
		public String getEmPassword() {
			return emPassword;
		}
		// Set Password Employee
		public void setEmPassword(String password) {
			this.emPassword = password;
		}
		
	
}
