package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.entitys.Role;


public class RoleDaoImpl implements Dao <Role>{
	
	private String url;
	private String user;
	private String pass;	
	
	public RoleDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public boolean insert(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role find(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Role> findAll() {
		ArrayList<Role> roles = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSTMENT_USERS_ROLES");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			roles.add(new Role(rs.getInt(1), rs.getString(2)));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return roles;
	}

}
