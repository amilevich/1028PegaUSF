package com.project.saintsbank;

public class SaintsBankAdmin extends Customer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1820934468498119089L;
	
	private int adminId = 1852;
	private String adminUser = "marcus";
	private String adminPass = "Saints19";
	
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

  public String getAdminPass() {
		return adminPass;
	}




	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}




	SaintsBankMenu scanb = new SaintsBankMenu();
	
	public SaintsBankAdmin() {
		
		
	}
	
	
	
	 
	public boolean cancel() {
		//Boolean confirm = false;
		String choice;
		System.out.println("*************CANCELLATION OF ACCOUNT IN PROGRESS**********");
		System.out.println("Are you sure you would like to cancel the account(Y/N)? \n");
		choice = scan.info.nextLine();
		
		if(choice.equals("Y") || choice.equals("y")) {
			System.out.println("You have successfully cancelled the account");
			return true;
		}
		else if(choice.equals("N") || choice.equals("n")){
			System.out.println("Input reflects No cancellation at this time");
			return false;
		}
		else{
			System.out.println("Your input doesn't validate your choice given, Please try again? ");
			cancel();
			return false;
				
		}
	}
}
