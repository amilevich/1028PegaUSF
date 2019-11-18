package bankaccount;

import java.util.Scanner;

public  class account {

	static int checkingBalance;
	static int savingsBalance;
	
	public void ifCustomerOpensNewAccount() {

	}
	
		 
	
	
	public static void jointAccount(int initialCheckingBalance, int initialSavingsBalance) {
		checkingBalance = initialCheckingBalance;
		savingsBalance = initialSavingsBalance;
	}
	
	public  void CheckBalance() {
		System.out.println("Your checking balance is " + checkingBalance);
		System.out.println("Your savings balance is  " + savingsBalance);
	}
	
	public void deposit(int amountToDepositInChecking, int amountToDepositInSavings) {
		checkingBalance = amountToDepositInChecking + checkingBalance;
		savingsBalance = amountToDepositInSavings + savingsBalance;
		System.out.println("You just deposited " + amountToDepositInChecking + " your checking account!");
		System.out.println("You just deposited " + amountToDepositInSavings + " your savings account!" );
	}
	
	public double withdraw(int amountToWithdrawFromChecking, int amountToWithdrawFromSavings) {
		checkingBalance = checkingBalance - amountToWithdrawFromChecking;
		savingsBalance = savingsBalance - amountToWithdrawFromSavings;
		System.out.println("You withdrew  " + amountToWithdrawFromChecking + " from your checking account.");
		System.out.println("You withdrew " + amountToWithdrawFromChecking + " from your savings account.");
		return checkingBalance + savingsBalance;
		
	}
	

	
//	account CheckingAndSavingsAccount = new account();
//	//To check balance:
//			CheckingAndSavingsAccount.CheckBalance();
//			
//			//Withdraw from account:
//			CheckingAndSavingsAccount.withdraw(0,0);
//			
//			//check balance once more:
//			CheckingAndSavingsAccount.CheckBalance();
//			
//			//deposit money into account:
//			CheckingAndSavingsAccount.deposit(0,0);
//			
//			//check balance once more:
//			CheckingAndSavingsAccount.CheckBalance();
//			
//			//System.out.println(checkingaccount);
			
	

	
	
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Saints bank! " +
		 "Is this your first time being a customer with us?");
		
		sc.nextLine();
		
		boolean customerHasAccount = true; {
			if(customerHasAccount) {
				System.out.println("Please fill out an application, so we can see if you will be approved. ");
			} else {
				System.out.println("Please use your username and password to login into your account. ");
			}
			
			sc.nextLine();
			
			System.out.println("Application is currently being reviewed by an Employee. ");
			
			sc.nextLine();
			
			System.out.println("Input Employee login ID");
			
			sc.nextLine();
			
			
			System.out.println("Good afternoon ");
			Employee  employee = new Employee();
			
			System.out.println("Id: " +employee.empId+" Name: "+ employee.empName);
			//System.out.println(employee.empName);
			
			sc.nextLine();
			
			System.out.println("Employee has improved application. ");
			
			sc.nextLine();
			
			System.out.println("Congrats on being approved for a joint banking account!");
			
			sc.nextLine();
			
//			System.out.println("Input Login username and password that you created! ");
//			
//			sc.nextLine();
//			
			
			
			
		
	
		
	
	
	
	
	
	
	
		}
	
		}		

}
