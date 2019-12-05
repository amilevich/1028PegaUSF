package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.entitys.Role;
import com.example.entitys.User;

public class UserDaoImpl implements Dao<User>{
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }

	
	private String url = "jdbc:oracle:thin:@dbtraining.ccdruazatxie.us-east-2.rds.amazonaws.com:1521:ORCL";
	private String user = "ersproject";
	private String pass = "ers0";
	
	public UserDaoImpl() {
		super();
	
	}	
	
	public UserDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}	

	@Override
	public boolean insert(User t) {
		
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSTMENT_USERS VALUES(?,?,?,?,?,?)");
			
			ps.setInt(1, 0);
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getName());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getRole().getId());
						
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(String s) {
		
		User fuser = null;
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
		try(Connection conn = DriverManager.getConnection(this.url, this.user, this.pass)){
			
			System.out.println("pppbbbbbbbbppppp ");
			
		PreparedStatement ps = conn.prepareStatement("SELECT RU.REIMB_USERS_ID, RU.REIMB_USERS_USERNAME, RU.REIMB_USERS_PASSWORD, " +
				                                            "RU.REIMB_USERS_NAME, RU.REIMB_USERS_EMAIL, RUR.REIMB_USERS_ROLE_ID, RUR.REIMB_USERS_ROLE " + 							
				                                      "FROM REIMBURSTMENT_USERS RU INNER JOIN REIMBURSTMENT_USERS_ROLES RUR ON RU.REIMB_USERS_ROLE_ID = RUR.REIMB_USERS_ROLE_ID " +
				                                      "WHERE RU.REIMB_USERS_USERNAME = ? OR RU.REIMB_USERS_EMAIL = ?");
		ps.setString(1, s);
		ps.setString(2, s);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
						
			fuser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Role(rs.getInt(6), rs.getString(7)));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return fuser;
	}

	@Override
	public ArrayList<User> findAll() {
		
		ArrayList<User> listuser = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT RU.REIMB_USERS_ID, RU.REIMB_USERS_USERNAME, RU.REIMB_USERS_PASSWORD, " +
				                                            "RU.REIMB_USERS_NAME, RU.REIMB_USERS_EMAIL, RUR.REIMB_USERS_ROLE_ID, RUR.REIMB_USERS_ROLE " + 							
				                                      "FROM REIMBURSTMENT_USERS RU INNER JOIN REIMBURSTMENT_USERS_ROLES RUR ON RU.REIMB_USERS_ROLE_ID = RUR.REIMB_USERS_ROLE_ID");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			listuser.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Role(rs.getInt(6), rs.getString(7))));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listuser;
	}

}
