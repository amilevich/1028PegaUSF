package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reimbursement.Reimbursement;

public class DaoReimbursementTmpl implements DaoReimbursementInterface {
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }
	
	
	private static String url = "jdbc:oracle:thin:@db1028.cnv5m4h5vxru.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "ReimbursementDB";
	private static String password = "password123";
	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Reimbursement getAllReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addReimbursement(Reimbursement reimbursement) {
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ers_reimbursement VALUES(?,?,?,?,?, ?, ?, ?, ? ,?)");
			ps.setInt(1, reimbursement.getReimbId());
			ps.setFloat(2,  reimbursement.getReimbAmt());
			ps.setString(3,  reimbursement.getReimbursementSubmitted());
			ps.setString(4,  reimbursement.getReimbursementResolved());
			ps.setString(5, reimbursement.getReimbDesc());
			ps.setString(6, reimbursement.getReimbReceipt());
			ps.setInt(7, reimbursement.getReimbAuthor());
			ps.setInt(8, reimbursement.getReimbResolver());
			ps.setInt(9, reimbursement.getReimbStatusId());
			ps.setInt(10, reimbursement.getReimbTypeId());
			ps.executeUpdate();
			conn.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		
	}
	
}
