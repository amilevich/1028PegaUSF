package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.entitys.Status;

public class StatusDaoImpl implements Dao<Status>{
	
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
	
	public StatusDaoImpl() {
		super();


	}		
	
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
		Status status = null;
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSTMENT_STATUS WHERE REIMB_STATUS=?");
			ps.setString(1, s);                            
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				status = new Status(rs.getInt(1), rs.getString(2));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
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
	
