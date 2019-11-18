package BankingApp;

public class Users {
	
	private String username;
	private String password;
	private String role;
	
	public Users(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
	public String serialize() {
		return username + "," + password + "," + role;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public String getRole() {
		return role;
	}
	
	
	
}
