package com.project.saintsbank;

import org.apache.log4j.Logger;

import com.project.saintsdao.SaintsBankCImp;

public class SaintsBankAdmin extends Customer {
	
	final static Logger EntryLoog = Logger.getLogger(SaintsBankAdmin.class);
	
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
	
	public void alogin(int eKey) {
		int efoundId = 0;
		
		//Employee ebankUser = new Employee();
		 
		 System.out.println("***************************");
			System.out.println("******EMPLOYEE LOGIN*******");
			System.out.println("***************************");
			System.out.println("\n\n");
			
			SaintsBankCImp adml = new SaintsBankCImp();
			//Searching the employee table for an employee id
			  efoundId = adml.searchId(eKey, 3);
					 
			if(eKey == efoundId) {
			 SaintsBankAdmin abankUser = adml.findByAdmin(eKey);
				System.out.println("Please enter your Username?");
				 String user = scanb.info.nextLine();
				if(user.equals(abankUser.getAdminUser()) == true) {
					System.out.println("Please enter your Password?");
						String ePass = scanb.info.nextLine();
						if(ePass.equals(abankUser.getAdminPass()) == true) {
							System.out.println("Employee login Successful");
							EntryLoog.info("Admin " + abankUser.getAdminId() + " has logged in");
							 scanb.menuChoiceAccount(3, eKey);
						}// end of password check
						else {
							System.out.println("Password is incorrect");
							scanb.menuLevelOne();
						}// end of password else
				}// end of username check
					else {
						System.out.println("Username doesn't match id ");
						scanb.menuLevelOne();
					}// end of username else
				
					
			}// end of userid check
			else{
				System.out.println("UserID doesn't match");
				scanb.menuLevelOne();
			}
	
		 
	 } 




	
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
	}// End of Cancel Class
}
