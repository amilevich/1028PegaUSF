package project0PartOne;

import java.util.ArrayList;
import java.util.Random;

public class Administrator {
	////////////////////////////////////////////////////////// ADMINISTRATOR
	Random rand = new Random();
	////////////////////////////////////////////////////////// ATTRIBUTES/////////////////////////////////////////////////////////
	private String administratorFirstName;// administrator's first name
	private String administratorLastName; // administrator's last name
	private int administratorID; // administrator's Identification number
	private String administratorUsername;// administrator's user name
	private String administratorPassword;// administrator's Password
	static ArrayList<Administrator> administrators = new ArrayList<Administrator>();

	/////////////////////////////////////////////////////////////// CONSTRUCTORS//////////////////////////////////////////////////////////
	public Administrator() {
		super();
	}

	public Administrator(String administratorFirstName, String administratorLastName, int administratorID,
			String administratorUsername, String administratorPassword) {
		super();
		this.administratorFirstName = administratorFirstName;
		this.administratorLastName = administratorLastName;
		this.administratorID = administratorID;
		this.administratorUsername = administratorUsername;
		this.administratorPassword = administratorPassword;
	}

	/////////////////////////////////////////////////////////////// GETTERS AND
	/////////////////////////////////////////////////////////////// SETTERS///////////////////////////////////////////////////
	public String getAdministratorFirstName() {// <--------------------this method retrieves the administrator's first
												// name when called
		return administratorFirstName;
	}

	public void setAdministratorFirstName(String administratorFirstName) {// this method sets the administrator's first
																			// name when called
		this.administratorFirstName = administratorFirstName;
	}

	public String getAdministratorLastName() {// <--------------------this method retrieves the administrator's last
												// name when called
		return administratorLastName;
	}

	public void setAdministratorLastName(String administratorLastName) {// this method sets the administrator's last
																		// name when called
		this.administratorLastName = administratorLastName;
	}

	public int getAdministratorID() {// <----------------------------this method retrieves the administrator's ID
										// number when called
		return administratorID;
	}

	public void setAdministratorID(int administratorID) {// <---------------this method sets the administrator's ID
															// number when called
		this.administratorID = administratorID;
	}

	public String getAdministratorUsername() {// <---------------------this method retrieves the administrator's user
												// name when called
		return administratorUsername;
	}

	public void setAdministratorUsername(String administratorUsername) {// --this method sets the administrator's user
																		// name when called
		this.administratorUsername = administratorUsername;
	}

	public String getAdministratorPassword() {// <--------------------this method retrieves the administrator's password
												// when called
		return administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword) {// --this method sets the administrator's
																		// password when called
		this.administratorPassword = administratorPassword;
	}
	/////////////////////////////////////////////////////////////// toSTRING-METHOD///////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Administrator FirstName: " + administratorFirstName + ", LastName: " + administratorLastName + ", ID: "
				+ administratorID + ", Username: " + administratorUsername + ", Password: " + administratorPassword;
	}

}
