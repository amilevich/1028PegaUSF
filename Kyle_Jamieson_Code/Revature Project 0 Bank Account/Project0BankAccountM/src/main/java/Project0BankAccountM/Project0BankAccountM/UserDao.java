package Project0BankAccountM.Project0BankAccountM;

import java.util.List;
import Project0BankAccountM.Project0BankAccountM.User;

public interface UserDao 
{
	//CREATE
	public int insertUser(User _user);
	//READ
	public List<User> selectUserByAccountNumber(int _number);
	public User selectUserByUsername(String _username);
	public List<User> selectUserByRealname(String _fname, String _lname);
	public List<User> selectAllUsers();
	public List<User> selectAllCustomerUsers();
	public List<User> selectAllEmployeeUsers();
	public List<User> selectAllAdminUsers();
	//UPDATE
	public int updateUser(User _user);
	//DELETE
	public boolean deleteUser(User _user);

}
