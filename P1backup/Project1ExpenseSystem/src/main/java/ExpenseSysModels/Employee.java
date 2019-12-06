package ExpenseSysModels;

public class Employee extends User{

	public Employee(String userName, String password, String firstName, String lastName, String email) {
		super(userName, password, firstName, lastName, email);
		this.role = 0;
	}
	
	public Employee(User user) {
        this.userID = user.userID;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email; 
    }
	//submit
	
	//view all
	
	//view one

}
