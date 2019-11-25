package project0PartOne;

import java.util.Random;

public class Customer {
	Random rand = new Random();
//////////////////////////////////////////////////////////CUSTOMER ATTRIBUTES/////////////////////////////////////////////////////////
	private int customerID;			 //customer's Identification number
	private String customerFirstName;//customer's first name
	private String customerLastName; //customer's last name
	private String customerUsername;//customer's user name
	private String customerPassword;//customer's Password
	
///////////////////////////////////////////////////////////////CONSTRUCTORS//////////////////////////////////////////////////////////
	public Customer() {
		
	}


	

public Customer(int customerID, String customerFirstName, String customerLastName, String customerUsername,
		String customerPassword) {
	super();
	this.customerID = customerID;
	this.customerFirstName = customerFirstName;
	this.customerLastName = customerLastName;
	this.customerUsername = customerUsername;
	this.customerPassword = customerPassword;
}




///////////////////////////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////
	public String getCustomerFirstName() {//<--------------------this method retrieves the customer's first name when called
		return customerFirstName;
	}


	public void setCustomerFirstName(String customerFirstName) {//this method sets the customer's first name when called
		this.customerFirstName = customerFirstName;
	}


	public String getCustomerLastName() {//<--------------------this method retrieves the customer's last name when called
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {//this method sets the customer's last name when called
		this.customerLastName = customerLastName;
	}


	public int getCustomerID() {//<----------------------------this method retrieves the customer's ID number when called
		return customerID;
	}


	public void setCustomerID(int customerID) {//<---------------this method sets the customer's ID number when called
		this.customerID = customerID;
	}


	public String getCustomerUsername() {//<---------------------this method retrieves the customer's user name when called
		return customerUsername;
	}


	public void setCustomerUsername(String customerUsername) {//--this method sets the customer's user name when called
		this.customerUsername = customerUsername;
	}


	public String getCustomerPassword() {//<--------------------this method retrieves the customer's password when called
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {//--this method sets the customer's password when called
		this.customerPassword = customerPassword;
	}

///////////////////////////////////////////////////////////////toSTRING-METHOD///////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Customer FirstName: " + customerFirstName + ", LastName: " + customerLastName
				+ ", ID: " + customerID + ", Username: " + customerUsername + ", Password: "
				+ customerPassword;
	}
}
