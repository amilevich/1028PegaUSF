package bankaccount;

public class Customer  {
	public String username;
	protected String password;
	
	
	Customer(String username, String password){
		this.username =username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = "DojaTheMane";
	}


	protected String getPassword() {
		return password;
	}


	protected void setPassword(String password) {
		this.password = "ProtectMyMoney$$";
	}
	
	
	
}

