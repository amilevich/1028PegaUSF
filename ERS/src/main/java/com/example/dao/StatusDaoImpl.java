package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.entitys.Status;

public class StatusDaoImpl implements Dao<Status>{

	private String url;
	private String user;
	private String pass;	
	
	public StatusDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}	
	
	@Override
	public boolean insert(Status t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Status t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Status t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Status find(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Status> findAll() {
		
		ArrayList<Status> status = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSTMENT_STATUS");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			status.add(new Status(rs.getInt(1), rs.getString(2)));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;

	}
}
	
