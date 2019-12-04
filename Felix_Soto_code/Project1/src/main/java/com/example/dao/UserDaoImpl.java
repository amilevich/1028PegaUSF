package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Users;

public class UserDaoImpl implements UserDao {
	  static{

          try {

              Class.forName("oracle.jdbc.driver.OracleDriver");

          } catch (ClassNotFoundException e) {

              e.printStackTrace();

          }

      }
	
	private static String url = "jdbc:oracle:thin:@db1028.c6ogbmwpzun0.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "project1";
	private static String password = "passw0rd";


	@Override
	public int insertUser(Users u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS VALUES(?,?,?,?,?,?,?)");

			ps.setInt(1, u.getUserID());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getUserFname());
			ps.setString(5, u.getUserLname());
			ps.setString(6, u.getUserEmail());
			ps.setInt(7, u.getUserRoleID());

			System.out.println(u);
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public Users selectUserByUsername(String Username) {
		
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			ps.setString(2, Username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				new Users(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
}