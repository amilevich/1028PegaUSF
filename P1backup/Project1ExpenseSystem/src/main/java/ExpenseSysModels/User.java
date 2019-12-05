package ExpenseSysModels;

public class User {
	//static int highestID;
	int userID;
	String userName;
	String password;
	String firstName;
	String lastName;
	String email;
	int role;
	
	//login
	
//	public static int getHighestID() {
//		return highestID;
//	}
//	public static void setHighestID() {
//		//look up highest ID from user table
//		User.highestID = highestID;
//	}
	
	public String getUserName() {
		return userName;
	}
	public User(int userID, String userName, String password, String firstName, String lastName, String email) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public User(int userID, String userName, String password, String firstName, String lastName, String email, int role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	public User() {
	}
	public void setUserName(String un) {
		this.userName = un;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pw) {
		this.password = pw;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return this.role;
	}
	void setRole() {
		
	}
	
}
