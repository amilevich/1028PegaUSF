package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pega.dao.ERS_USERS_DAO;
import com.pega.models.ERS_USERS;

public class ERS_USERS_DAO_IMPL implements ERS_USERS_DAO{

	private static String url = "jdbc:oracle:thin:@db1028pega.chunhpttrxjn.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "";
	private static String password = "";
	
	@Override
	public int insertUser(ERS_USERS user) {
		
		int insertedReimbs = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO ERS_USERS(ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME,"
					+ " USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID_FK) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, user.getERS_USERS_ID());
			ps.setString(2, user.getERS_USERNAME());
			ps.setString(3, user.getERS_PASSWORD());
			ps.setString(4, user.getUSER_FIRST_NAME());
			ps.setString(5, user.getUSER_LAST_NAME());
			ps.setString(6, user.getUSER_EMAIL());
			ps.setInt(7, user.getUSER_ROLE_ID_FK());
			insertedReimbs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertedReimbs;
		
	}

	@Override
	public ERS_USERS selectById(int ERS_USER_ID) {
		
		ERS_USERS user = null;
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"),rs.getString("ERS_USERNAME"),
									 rs.getString("ERS_PASSWORD"),rs.getString("USER_FIRST_NAME"),
									 rs.getString("USER_LAST_NAME"),rs.getString("USER_EMAIL"),rs.getInt("USER_ROLE_ID_FK"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public ERS_USERS selectByUsername(String USER_USERNAME) {
		
		ERS_USERS user = null;
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			
			ps.setString(1, USER_USERNAME);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"),rs.getString("ERS_USERNAME"),
						 rs.getString("ERS_PASSWORD"),rs.getString("USER_FIRST_NAME"),
						 rs.getString("USER_LAST_NAME"),rs.getString("USER_EMAIL"),rs.getInt("USER_ROLE_ID_FK")); 
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public ERS_USERS selectByPassword(String USER_PASSWORD) {
		
ERS_USERS user = null;
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_PASSWORD=?");
			
			ps.setString(1, USER_PASSWORD);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"),rs.getString("ERS_USERNAME"),
						 rs.getString("ERS_PASSWORD"),rs.getString("USER_FIRST_NAME"),
						 rs.getString("USER_LAST_NAME"),rs.getString("USER_EMAIL"),rs.getInt("USER_ROLE_ID_FK")); 
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	



	@Override
	public List<ERS_USERS> selectAllUsers() {
		
		List<ERS_USERS> user = new ArrayList<ERS_USERS>();
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.add(new ERS_USERS(rs.getInt("ERS_USERS_ID"),rs.getString("ERS_USERNAME"),
						 rs.getString("ERS_PASSWORD"),rs.getString("USER_FIRST_NAME"),
						 rs.getString("USER_LAST_NAME"),rs.getString("USER_EMAIL"),rs.getInt("USER_ROLE_ID_FK"))); 
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int updateUserById(ERS_USERS user) {
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = con.prepareStatement("UPDATE ERS_USERS ERS_USERNAME=?, ERS_PASSWORD=?, USER_FIRST_NAME=?, USER_LAST_NAME=?, USER_EMAIL=?, USER_ROLE_ID_FK=?, WHERE ERS_USERS_ID=? ");
			
			ps.setInt(1, user.getERS_USERS_ID());
			ps.setString(2, user.getERS_USERNAME());
			ps.setString(3, user.getERS_PASSWORD());
			ps.setString(4, user.getUSER_FIRST_NAME());
			ps.setString(5, user.getUSER_LAST_NAME());
			ps.setString(6, user.getUSER_EMAIL());
			ps.setInt(7, user.getUSER_ROLE_ID_FK());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"),rs.getString("ERS_USERNAME"),
						 rs.getString("ERS_PASSWORD"),rs.getString("USER_FIRST_NAME"),
						 rs.getString("USER_LAST_NAME"),rs.getString("USER_EMAIL"),rs.getInt("USER_ROLE_ID_FK")); 
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}


}
