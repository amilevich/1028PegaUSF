package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.entitys.Type;

public class TypeDaoImpl implements Dao<Type> {
	
	private String url;
	private String user;
	private String pass;	
	
	public TypeDaoImpl(String url, String user, String pass) {
		
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}	
	

	@Override
	public boolean insert(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type find(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Type> findAll() {
		
		ArrayList<Type> types = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSTMENT_STATUS");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			types.add(new Type(rs.getInt(1), rs.getString(2)));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return types;
	}

}
