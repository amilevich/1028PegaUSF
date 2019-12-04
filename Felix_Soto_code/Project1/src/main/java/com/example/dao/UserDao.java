package com.example.dao;

import com.example.model.Users;

public interface UserDao {

	public int insertUser(Users u);
	public Users selectUserByUsername(String username);
}