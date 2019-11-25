package BankingApp;

import java.util.List;

public interface UsersDao {

	//CREATE
	public int insertUser(Users u);
	//READ
	public Users selectUserByName (String name);
	public List<Users> selectAllUsers();
	//UPDATE
	public int updateUsers(Users u);
	//DELETE
	public int deleteUsers(Users u);

}
