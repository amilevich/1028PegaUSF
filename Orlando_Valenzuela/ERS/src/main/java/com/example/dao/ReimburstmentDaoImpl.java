package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.example.entitys.Reimburstment;
import com.example.entitys.Status;
import com.example.entitys.Type;
import com.example.entitys.User;

public class ReimburstmentDaoImpl implements Dao<Reimburstment> {
	
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }	

	final static Logger loggy = Logger.getLogger(ReimburstmentDaoImpl.class);
	
	private String url = "jdbc:oracle:thin:@dbtraining.ccdruazatxie.us-east-2.rds.amazonaws.com:1521:ORCL";
	private String user = "ersproject";
	private String pass = "ers0";	
	
	public ReimburstmentDaoImpl() {
		super();
	
	}
	
	public ReimburstmentDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}	
	
	@Override
	public boolean insert(Reimburstment t) {
		
		loggy.info("inside insert ReimburstmentDaoImpl");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
				
			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSTMENT VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, 0);
			ps.setDouble(2, t.getAmount());
			ps.setTimestamp(3, t.getSubmit());
			ps.setTimestamp(4, t.getResolved());
			ps.setString(5, t.getDescription());
			ps.setBlob(6, t.getReceipt());
			ps.setInt(7, t.getUser().getId());
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
		
		loggy.info("inside delete ReimburstmentDaoImpl");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("DELETE REIMBURSTMENT WHERE REIMB_ID = ?");
			ps.setInt(1, t.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Reimburstment t) {
		
		loggy.info("inside update ReimburstmentDaoImpl");
		
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
		
		loggy.info("inside findAll ReimburstmentDaoImpl");
		
		ArrayList<Reimburstment> reimburstments = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMIT, R.REIMB_RESOLVED, R.REIMB_DESCRIPTION, R.REIMB_RECEIPT, " + 
													 "	   RS.REIMB_STATUS_ID, RS.REIMB_STATUS, RT.REIMB_TYPE_ID, RT.REIMB_TYPE, " + 
													 "	   RU.REIMB_USERS_ID, RU.REIMB_USERS_USERNAME, RU.REIMB_USERS_PASSWORD, RU.REIMB_USERS_NAME, RU.REIMB_USERS_EMAIL " + 
													 "FROM REIMBURSTMENT R INNER JOIN REIMBURSTMENT_STATUS RS ON R.REIMB_STATUS_ID = RS.REIMB_STATUS_ID " + 
													 "					   INNER JOIN REIMBURSTMENT_TYPE RT ON R.REIMB_TYPE_ID = RT.REIMB_TYPE_ID  " + 
													 "					   INNER JOIN REIMBURSTMENT_USERS RU ON R.REIMB_USERS_ID = RU.REIMB_USERS_ID");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Status status = new Status(rs.getInt(7), rs.getString(8));
			Type type = new Type( rs.getInt(9), rs.getString(10));
			User tuser = new User(rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), null);
				
 			reimburstments.add(new Reimburstment(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), 
					           null, rs.getString(5), rs.getBlob(6),  null, status, type, tuser ));
		}
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return reimburstments;
	}
	
	public ArrayList<Reimburstment> findAll(User u) {
		
		loggy.info("inside findAll for User  ReimburstmentDaoImpl");
		
		ArrayList<Reimburstment> reimburstments = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMIT, R.REIMB_RESOLVED, R.REIMB_DESCRIPTION, R.REIMB_RECEIPT,  " + 
														"													 	   RS.REIMB_STATUS_ID, RS.REIMB_STATUS, RT.REIMB_TYPE_ID, RT.REIMB_TYPE, " + 
														"													 	   RU.REIMB_USERS_ID, RU.REIMB_USERS_USERNAME, RU.REIMB_USERS_PASSWORD, RU.REIMB_USERS_NAME, RU.REIMB_USERS_EMAIL  " + 
														" FROM REIMBURSTMENT R INNER JOIN REIMBURSTMENT_STATUS RS ON R.REIMB_STATUS_ID = RS.REIMB_STATUS_ID " + 
														"                      INNER JOIN REIMBURSTMENT_TYPE RT ON R.REIMB_TYPE_ID = RT.REIMB_TYPE_ID  " + 
														"                      INNER JOIN REIMBURSTMENT_USERS RU ON R.REIMB_USERS_ID = RU.REIMB_USERS_ID " + 
														" WHERE R.REIMB_USERS_ID =?");
		ps.setInt(1, u.getId());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {

			
			Status status = new Status(rs.getInt(7), rs.getString(8));
			Type type = new Type( rs.getInt(9), rs.getString(10));
			User tuser = new User(rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), null);
				
 			reimburstments.add(new Reimburstment(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), 
					           null, rs.getString(5), rs.getBlob(6),  null, status, type, tuser ));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimburstments;
	}	

}
