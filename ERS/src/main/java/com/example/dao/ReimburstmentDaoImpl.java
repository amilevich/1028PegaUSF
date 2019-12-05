package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.example.entitys.Reimburstment;
import com.example.entitys.Status;
import com.example.entitys.Type;
import com.example.entitys.User;

public class ReimburstmentDaoImpl implements Dao<Reimburstment> {

	
	private String url;
	private String user;
	private String pass;	
	
	public ReimburstmentDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}	
	
	@Override
	public boolean insert(Reimburstment t) {
		
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
				
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNTBANK VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, 0);
			ps.setDouble(2, t.getAmount());
			ps.setTimestamp(3, t.getSubmit());
			ps.setTimestamp(4, t.getResolved());
			ps.setString(5, t.getDescription());
			ps.setBlob(6, t.getReceipt());
			ps.setInt(7, t.getResolver().getId());
			ps.setInt(8, t.getStatus().getId());
			ps.setInt(9, t.getType().getId());
			ps.setInt(10, t.getUser().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(Reimburstment t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reimburstment t) {
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE REIMBURSTMENT SET REIMB_RESOLVED = ?, REIMB_RESOLVER_ID = ?, REIMB_STATUS_ID = ? WHERE REIMB_ID = ?");
			
			ps.setTimestamp(1, t.getResolved());
			ps.setInt(2, t.getResolver().getId());
			ps.setInt(3, t.getStatus().getId());
			ps.setInt(4, t.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Reimburstment find(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimburstment> findAll() {
		
		ArrayList<Reimburstment> reimburstments = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMIT, R.REIMB_RESOLVED, R.REIMB_DESCRIPTION, R.REIMB_RECEIPT, " + 
													"      RUR.REIMB_USERS_ID, RUR.REIMB_USERS_USERNAME, RUR.REIMB_USERS_PASSWORD, RUR.REIMB_USERS_NAME, RUR.REIMB_USERS_EMAIL, RUR.REIMB_USERS_ROLE_ID, " + 
													"      RS.REIMB_STATUS_ID, RS.REIMB_STATUS, RT.REIMB_TYPE_ID, RT.REIMB_TYPE, " + 
													"      RU.REIMB_USERS_ID, RU.REIMB_USERS_USERNAME, RU.REIMB_USERS_PASSWORD, RU.REIMB_USERS_NAME, RU.REIMB_USERS_EMAIL, RU.REIMB_USERS_ROLE_ID " + 
													"FROM REIMBURSTMENT R INNER JOIN REIMBURSTMENT_USERS RUR ON R.REIMB_RESOLVER_ID = RUR.REIMB_USERS_ID " + 
													"                     INNER JOIN REIMBURSTMENT_STATUS RS ON R.REIMB_STATUS_ID = RS.REIMB_STATUS_ID " + 
													"                     INNER JOIN REIMBURSTMENT_TYPE RT ON R.REIMB_TYPE_ID = RT.REIMB_TYPE_ID " + 
													"                     INNER JOIN REIMBURSTMENT_USERS RU ON R.REIMB_RESOLVER_ID = RU.REIMB_USERS_ID");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			
			reimburstments.add(new Reimburstment(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), 
					           rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), (rs.getInt(7) > 0)? new User(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), null): null,
					           new Status(rs.getInt(13), rs.getString(14)), new Type( rs.getInt(15), rs.getString(16)),
					           (rs.getInt(17) > 0)? new User(rs.getInt(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), null): null));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimburstments;
	}
	
	public ArrayList<Reimburstment> findAll(User u) {
		
		ArrayList<Reimburstment> reimburstments = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMIT, R.REIMB_RESOLVED, R.REIMB_DESCRIPTION, R.REIMB_RECEIPT, " + 
													"      RUR.REIMB_USERS_ID, RUR.REIMB_USERS_USERNAME, RUR.REIMB_USERS_PASSWORD, RUR.REIMB_USERS_NAME, RUR.REIMB_USERS_EMAIL, RUR.REIMB_USERS_ROLE_ID, " + 
													"      RS.REIMB_STATUS_ID, RS.REIMB_STATUS, RT.REIMB_TYPE_ID, RT.REIMB_TYPE, " + 
													"      RU.REIMB_USERS_ID, RU.REIMB_USERS_USERNAME, RU.REIMB_USERS_PASSWORD, RU.REIMB_USERS_NAME, RU.REIMB_USERS_EMAIL, RU.REIMB_USERS_ROLE_ID " + 
													"FROM REIMBURSTMENT R INNER JOIN REIMBURSTMENT_USERS RUR ON R.REIMB_RESOLVER_ID = RUR.REIMB_USERS_ID " + 
													"                     INNER JOIN REIMBURSTMENT_STATUS RS ON R.REIMB_STATUS_ID = RS.REIMB_STATUS_ID " + 
													"                     INNER JOIN REIMBURSTMENT_TYPE RT ON R.REIMB_TYPE_ID = RT.REIMB_TYPE_ID " + 
													"                     INNER JOIN REIMBURSTMENT_USERS RU ON R.REIMB_RESOLVER_ID = RU.REIMB_USERS_ID " +
													"WHERE R.REIMB_ID =?");
		ps.setInt(1, u.getId());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			
			reimburstments.add(new Reimburstment(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), 
					           rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), (rs.getInt(7) > 0)? new User(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), null): null,
					           new Status(rs.getInt(13), rs.getString(14)), new Type( rs.getInt(15), rs.getString(16)),
					           (rs.getInt(17) > 0)? new User(rs.getInt(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), null): null));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimburstments;
	}	

}
