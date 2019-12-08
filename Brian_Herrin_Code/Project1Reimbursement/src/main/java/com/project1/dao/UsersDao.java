package com.project1.dao;
import java.util.List;

import com.project1.model.Users;

public interface UsersDao {
	public void insertUsers(Users users);
	public Users selectUsers(String name);
	public Users selectUsersByPassword(String userPassword);
	public Users selectUsersByID(int userId);
	public List<Users> selectAllUsers();
	//public Users updateUsers(Users user);
	public void updateUsers(Users user);
	public Users updateUsersById(int userId);
	public Users updateUsersByName(String userName);
}
